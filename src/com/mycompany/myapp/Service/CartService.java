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
import com.mycompany.myapp.Entite.Cart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MOHAMED
 */
public class CartService {

    public ArrayList<Cart> parseListItemJson(String json) {
        ArrayList<Cart> listItems = new ArrayList<>();
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
                Cart e = new Cart();

                float price = Float.parseFloat(obj.get("price").toString());
                float id_category = Float.parseFloat(obj.get("total").toString());
                
                e.setItem_name(obj.get("itemName").toString());
                e.setImage(obj.get("image").toString());
                
                e.setPrice((int) price);
                e.setTotal((int) id_category);

                System.out.println(e);

                listItems.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listItems);
        return listItems;
    }
    ArrayList<Cart> listCarts1 = new ArrayList<>();

    public ArrayList<Cart> getListAll() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/FiskitWeb-master/web/app_dev.php/eshop/cart/all");
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CartService ser = new CartService();
                listCarts1 = ser.parseListItemJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCarts1;
    }
}
