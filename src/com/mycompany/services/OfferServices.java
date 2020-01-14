package com.mycompany.services;

import com.mycompany.Entite.Offer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class OfferServices {

    public ArrayList<Offer> parseListEventsJson(String json) {

        ArrayList<Offer> listEvents = new ArrayList<>();

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
            Map<String, Object> Offer = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) Offer.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Offer o = new Offer();
                        o.setId_Offer((int) Float.parseFloat(obj.get("idOffer").toString()));
                        o.setId_Offer_Owner(5);
                        System.out.println("moudi");
                        o.setSubject(obj.get("subject").toString());
                        o.setCategory(obj.get("category").toString());
                        o.setDescription(obj.get("description").toString());
                        o.setBudget(obj.get("budget").toString());
                        o.setLocation(obj.get("location").toString());                        
                        Map<String, Object> obj1 = (Map<String, Object>) (obj.get("datePublished"));
                        double dd = Double.parseDouble(obj1.get("timestamp").toString());
                        o.setDate_Published(new Date((long) dd * 1000).toString());
                        o.setOfferStatus(obj.get("offerStatus").toString());
                        o.setAttachment(obj.get("attachment").toString());
                
                listEvents.add(o);
            }
        } catch (IOException ex) {
        }
        System.out.println(listEvents);
        return listEvents;

    }
    
    
    ArrayList<Offer> listEvents = new ArrayList<>();
    
    public ArrayList<Offer> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://127.0.0.1:8000/user/offer/showM");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                OfferServices ser = new OfferServices();
                listEvents = ser.parseListEventsJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
}
