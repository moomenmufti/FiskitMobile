/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.myapp.Entite.Item;
import com.mycompany.myapp.Service.ItemService;
import java.util.ArrayList;

/**
 *
 * @author MOHAMED
 */
public class AddToCart extends Form {

    public AddToCart(Resources theme, Integer id) {
        setTitle("Add To Cart");
        ArrayList<Item> li = new ArrayList<>();
        ItemService is = new ItemService();
        Item i = new Item();
        li = is.getListAll();
        for (int counter = 0; counter < li.size(); counter++) {
            if (li.get(counter).getId_item() == id) {
                i = li.get(counter);
            }
        }
        Container d0 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ImageViewer imgConAF = new ImageViewer();
        EncodedImage palceHolderAF = EncodedImage.createFromImage(theme.getImage("airfrance.png").scaled(250, 250), false);
        URLImage urlImageAF = URLImage.createToStorage(palceHolderAF, i.getImage(), "http://localhost/FiskitWeb-master/web/uploads/images/" + i.getImage());
        imgConAF.setImage(urlImageAF);
        d0.add(imgConAF);
        Label Lqty = new Label("Quantity:");
        TextField qty = new TextField("", "Enter Quantity");
        Validator val = new Validator();
        val.addConstraint(qty, new NumericConstraint(true));
        val.setValidateOnEveryKey(true);
        Button cnf = new Button("Confirm");
        Item i1 = new Item(id, i.getItem_name(), i.getDescription(), i.getCreation_date(), i.getPrice(), i.getId_user(), i.getId_category(), i.getImage(), i.getQuantity());
        getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showBack();
            }
        });
        getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showBack();
            }
        });
        cnf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (val.isValid()) {
                    if (is.AddToCarty(i1, Integer.parseInt(qty.getText()))) {
                        Dialog.show("Confirmed", "Your command was successful you will get a mail", "ok", null);
                        Eshop e = new Eshop(theme);
                        e.show();
                    } else {
                        Dialog.show("Error", "Connection Probleme", "ok", null);
                    }
                } else {
                    Dialog.show("Check", "Enter your quantity", "ok", null);
                }
            }
        });

        d0.add(Lqty);
        d0.add(qty);
        d0.add(cnf);
        add(d0);

    }
}
