/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Events;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author zomra
 */
public class ServiceEvents {

    public ArrayList<Events> parseListEventsJson(String json) {

        ArrayList<Events> listEvents = new ArrayList<>();

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
            Map<String, Object> events = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Events e = new Events();

                float id = Float.parseFloat(obj.get("idEvent").toString());
                float vacancies = Float.parseFloat(obj.get("vacancies").toString());
                float capacity = Float.parseFloat(obj.get("capacity").toString());

                e.setId_event((int) id);
                e.setTitle(obj.get("title").toString());
                e.setDescription(obj.get("description").toString());
                e.setPhoto(obj.get("photo").toString());
                e.setDate(obj.get("date").toString());
                e.setPlace(obj.get("place").toString());
                e.setVacancies((int) vacancies);
                e.setCapacity((int) capacity);
                System.out.println(e);
                
                listEvents.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listEvents);
        return listEvents;

    }
    
    
    ArrayList<Events> listEvents = new ArrayList<>();
    
    public ArrayList<Events> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidevfx/web/app_dev.php/event/allevents");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvents ser = new ServiceEvents();
                listEvents = ser.parseListEventsJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
}
