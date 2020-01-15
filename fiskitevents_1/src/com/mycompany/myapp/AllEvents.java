/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Events;
import com.mycompany.Service.ServiceEvents;
import java.util.ArrayList;

/**
 *
 * @author zomra
 */
public class AllEvents extends Form {
        
    public AllEvents(Resources theme){
        
        setTitle("Events");
        ServiceEvents ser=new ServiceEvents();
        ArrayList<Events> listEvents = new ArrayList<>();
        listEvents=ser.getList2();
        for (int i = 0; i < listEvents.size(); i++) {
            Events get = listEvents.get(i);
            Label titlel=new Label(get.getTitle());
            System.out.println(get.getId_event());
            add(titlel);
        }
   
    }
       
    }

