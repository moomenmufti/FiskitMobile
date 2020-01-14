/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entite.Item;
import com.mycompany.myapp.Service.ItemService;
import java.util.ArrayList;

/**
 *
 * @author MOHAMED
 */
public class Eshop extends Form {

    public Eshop(Resources theme) {
        setTitle("Eshop");

        ArrayList<Item> li = new ArrayList<>();
        ItemService is = new ItemService();
        li = is.getListAll();
        for (int counter = 0; counter < li.size(); counter++) {
            Item it = li.get(counter);
            Container d = new Container(new BoxLayout(BoxLayout.X_AXIS));
            ImageViewer imgConAF = new ImageViewer();
            EncodedImage palceHolderAF = EncodedImage.createFromImage(theme.getImage("airfrance.png").scaled(250, 250), false);
            URLImage urlImageAF = URLImage.createToStorage(palceHolderAF, it.getImage(), "http://localhost/FiskitWeb-master/web/uploads/images/" + it.getImage());
            imgConAF.setImage(urlImageAF);
            d.add(imgConAF);
            Container d1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label LNameItem = new Label("NameItem:");
            Label LPrice = new Label("Price:");
            d1.add(LNameItem);
            d1.add(LPrice);
            Container d2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label NameItem = new Label(it.getItem_name());
            Label Price = new Label(String.valueOf(it.getPrice()));
            d2.add(NameItem);
            d2.add(Price);
            d.add(d1);
            d.add(d2);
            add(d);
            imgConAF.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ShowItem si = new ShowItem(theme, it.getId_item());
                    si.show();
                }
            });
            NameItem.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ShowItem si = new ShowItem(theme, it.getId_item());
                    si.show();
                }
            });
            System.out.println(li.get(counter));
        }

        getToolbar().addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_SETTINGS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Home home = new Home(theme);
                home.show();
            }
        });
        getToolbar().addMaterialCommandToSideMenu("E-shop", FontImage.MATERIAL_SHOP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                refreshTheme();
            }
        });
        getToolbar().addMaterialCommandToSideMenu("My Cart", FontImage.MATERIAL_SHOPPING_CART, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ShowCart sc = new ShowCart(theme);
                sc.show();
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
