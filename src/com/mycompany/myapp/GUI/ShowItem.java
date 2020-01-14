/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
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
public class ShowItem extends Form {

    public ShowItem(Resources theme, Integer id) {

        ArrayList<Item> li = new ArrayList<>();
        ItemService is = new ItemService();
        Item i = new Item();
        String catergory = "";
        li = is.getListAll();
        for (int counter = 0; counter < li.size(); counter++) {
            if (li.get(counter).getId_item() == id) {
                i = li.get(counter);
                switch (i.getId_category()) {
                    case 1:
                        catergory = "CellPhones";
                        break;
                    case 2:
                        catergory = "Electronics";
                        break;
                    case 3:
                        catergory = "Houshold";
                        break;
                }
            }
        }
        setTitle(i.getItem_name());
//        Integer idItem = i.getId_item();
        Container d0 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ImageViewer imgConAF = new ImageViewer();
        EncodedImage palceHolderAF = EncodedImage.createFromImage(theme.getImage("airfrance.png").scaled(250, 250), false);
        URLImage urlImageAF = URLImage.createToStorage(palceHolderAF, i.getImage(), "http://localhost/FiskitWeb-master/web/uploads/images/" + i.getImage());
        imgConAF.setImage(urlImageAF);
        d0.add(imgConAF);
        Container d = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container d1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label LNameItem = new Label("NameItem:");
        Label LDescription = new Label("Description:");
        Label LPrice = new Label("Price:");
//        Label LCreationDate = new Label("CreationDate:");
        Label LCategory = new Label("Category:");
        d1.add(LNameItem);
        d1.add(LDescription);
        d1.add(LPrice);
//        d1.add(LCreationDate);
        d1.add(LCategory);

        Container d2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label NameItem = new Label(i.getItem_name());
        Label Description = new Label(i.getDescription());
        Label Price = new Label(String.valueOf(i.getPrice()));
//        Label CreationDate = new Label(i.getCreation_date());
        Label Category = new Label(catergory);

        d2.add(NameItem);
        d2.add(Description);
        d2.add(Price);
//        d2.add(CreationDate);
        d2.add(Category);
        d.add(d1);
        d.add(d2);
        d0.add(d);
        Button Add = new Button("Add To Cart");
        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AddToCart atc = new AddToCart(theme, id);
                atc.show();
            }
        });
        d0.add(Add);
        add(d0);
        

        getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Eshop e = new Eshop(theme);
                e.show();
            }
        });
    }

}
