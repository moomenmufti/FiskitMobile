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
import com.mycompany.myapp.Entite.Cart;
import com.mycompany.myapp.Entite.Item;
import com.mycompany.myapp.Service.CartService;
import com.mycompany.myapp.Service.ItemService;
import java.util.ArrayList;

/**
 *
 * @author MOHAMED
 */
public class ShowCart extends Form {

    public ShowCart(Resources theme) {
        setTitle("My Cart");
        Integer Total = 0;
        ArrayList<Cart> li = new ArrayList<>();
        CartService is = new CartService();
        li = is.getListAll();
        for (int counter = 0; counter < li.size(); counter++) {
            Cart it = li.get(counter);
            Total += it.getTotal();
            Container d = new Container(new BoxLayout(BoxLayout.X_AXIS));
            ImageViewer imgConAF = new ImageViewer();
            EncodedImage palceHolderAF = EncodedImage.createFromImage(theme.getImage("airfrance.png").scaled(250, 250), false);
            URLImage urlImageAF = URLImage.createToStorage(palceHolderAF, it.getImage(), "http://localhost/FiskitWeb-master/web/uploads/images/" + it.getImage());
            imgConAF.setImage(urlImageAF);
            d.add(imgConAF);
            Container d1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label LNameItem = new Label("NameItem:");
            Label LPrice = new Label("Price:");
            Label LQuantity = new Label("Quantity:");
            d1.add(LNameItem);
            d1.add(LPrice);
            d1.add(LQuantity);
            Container d2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label NameItem = new Label(it.getItem_name());
            Label Price = new Label(String.valueOf(it.getPrice()));
            Label Quantity = new Label(String.valueOf(it.getQuantity()));
            d2.add(NameItem);
            d2.add(Price);
            d2.add(Quantity);
            d.add(d1);
            d.add(d2);

            add(d);
            System.out.println(li.get(counter));
        }
        Label LTotal = new Label("Total:");
        Label Totale = new Label(String.valueOf(Total));
        add(LTotal);
        add(Totale);
        getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showBack();
            }
        });
        getToolbar().addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Home home = new Home(theme);
                home.show();
            }
        });
        getToolbar().addMaterialCommandToSideMenu("E-shop", FontImage.MATERIAL_SHOP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Eshop E = new Eshop(theme);
                E.show();
            }
        });
        getToolbar().addMaterialCommandToSideMenu("My Cart", FontImage.MATERIAL_SHOPPING_CART, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                refreshTheme();
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
