/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Entite.Item;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MOHAMED
 */
public class ItemService {

    public ArrayList<Item> parseListItemJson(String json) {
        ArrayList<Item> listItems = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            9olha root ta3 retour json 
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Item e = new Item();

                float id = Float.parseFloat(obj.get("idItem").toString());
                float price = Float.parseFloat(obj.get("price").toString());
                float id_category = Float.parseFloat(obj.get("idCategory").toString());
                float quantity = Float.parseFloat(obj.get("quantity").toString());

                e.setId_item((int) id);
                e.setItem_name(obj.get("itemName").toString());
                e.setDescription(obj.get("description").toString());
                e.setCreation_date(obj.get("creationDate").toString());
                e.setPrice((int) price);
                e.setId_category((int) id_category);
                e.setImage(obj.get("image").toString());
                e.setQuantity((int) quantity);
                System.out.println(e);

                listItems.add(e);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(listItems);
        return listItems;
    }

    public Boolean AddToCarty(Item i, Integer qty) {
        ConnectionRequest con = new ConnectionRequest();
        /*http://localhost:8000/locataire/
        wsnewlocal?idU=1&pw=123&name=json&address=blablabal&price=123&surface=123&capacity=123&x=1&y=2*/
        String Url = "http://localhost/FiskitWeb-master/web/app_dev.php/eshop/cart/new";
        con.setUrl(Url);
        con.setPost(false);
        //con.addArgument("idU", String.valueOf(getCurrentUser().getId()));
        //con.addArgument("pw", getCurrentUser().getPassword());
        con.addArgument("itemName", i.getItem_name());
        con.addArgument("idItem", String.valueOf(i.getId_item()));
        con.addArgument("idUser", "1");
        con.addArgument("image", i.getImage());
        con.addArgument("price", String.valueOf(i.getPrice()));
        con.addArgument("quantity", String.valueOf(qty));
        con.addArgument("total", String.valueOf(qty * i.getPrice()));
        NetworkManager.getInstance().addToQueueAndWait(con);
        String response = "";
        try {
            response = new String(con.getResponseData(), "utf-8");
        } catch (UnsupportedEncodingException ex) {
        }
        System.out.println(response);
        if (response.equals("true")) {
            return true;
        }
        return false;
//http://localhost/FiskitWeb-master/web/app_dev.php/eshop/cart/new?itemName=sqdhkjh&idItem=25&idUser=1&image=qhksdkjqd&price=5&quantity=5&total=25
    }

    ArrayList<Item> listItems = new ArrayList<>();

    public ArrayList<Item> getListAll() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/FiskitWeb-master/web/app_dev.php/eshop/item/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ItemService ser = new ItemService();
                listItems = ser.parseListItemJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listItems;
    }

//    ArrayList<Item> listItems1 = new ArrayList<>();
//
//    public ArrayList<Item> findItem(Integer id) {
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://localhost/FiskitWeb-master/web/app_dev.php/eshop/item/" + String.valueOf(id) + "/find");
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                ItemService ser = new ItemService();
//                listItems1 = ser.parseListItemJson(new String(con.getResponseData()));
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//        return listItems1;
//    }
}
