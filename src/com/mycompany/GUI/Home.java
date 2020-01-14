/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

/**
 *
 * @author MOHAMED
 */
public class Home extends Form {

    public Home(Resources theme) {
        setTitle("Home");
        getToolbar().addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                refreshTheme();
            }
        });
        getToolbar().addMaterialCommandToSideMenu("E-shop", FontImage.MATERIAL_SHOP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ShowOffer O = new ShowOffer();
                O.getF().show();
            }
        });
        getToolbar().addMaterialCommandToSideMenu("About", FontImage.MATERIAL_HELP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Form f = new Form();
                Label desc = new Label("TV, Computers, Appliance s, Air Conditioners and Mobile Phones. \r \n Life’s more about having the latest technology, \r \n FISKIT delivers consumer electronics that let you embrace life and prepare you for its greatest moments. \r \n After all, FISKIT, we know that life’s better when you’re prepared.");
                f.add(desc);
                f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        showBack();
                    }
                });
                f.show();
            }
        });
    }
}
