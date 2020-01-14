/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entite;

import java.util.Objects;

/**
 *
 * @author MOHAMED
 */
public class Item {

    private int id_item;
    private String item_name;
    private String description;
    private String creation_date;
    private int price;
    private User id_user;
    private int id_category;
    private String image;
    private int quantity;

    public Item() {
    }

    public Item(int id_item, String item_name, String description, String creation_date, int price, int id_category, String image, int quantity) {
        this.id_item = id_item;
        this.item_name = item_name;
        this.description = description;
        this.creation_date = creation_date;
        this.price = price;
        this.id_category = id_category;
        this.image = image;
        this.quantity = quantity;
    }

    public Item(int id_item, String item_name, String description, String creation_date, int price, User id_user, int id_category, String image) {
        this.id_item = id_item;
        this.item_name = item_name;
        this.description = description;
        this.creation_date = creation_date;
        this.price = price;
        this.id_user = id_user;
        this.id_category = id_category;
        this.image = image;
    }

    public Item(int id_item, String item_name, String description, int price, User id_user, int id_category, String image, int quantity) {
        this.id_item = id_item;
        this.item_name = item_name;
        this.description = description;
        this.price = price;
        this.id_user = id_user;
        this.id_category = id_category;
        this.image = image;
        this.quantity = quantity;
    }

    public Item(String item_name, String description, String creation_date, int price, User id_user, int id_category, String image) {
        this.item_name = item_name;
        this.description = description;
        this.creation_date = creation_date;
        this.price = price;
        this.id_user = id_user;
        this.id_category = id_category;
        this.image = image;
    }

    public Item(String item_name, String description, int price, User id_user, int id_category, String image, int quantity) {
        this.item_name = item_name;
        this.description = description;
        this.price = price;
        this.id_user = id_user;
        this.id_category = id_category;
        this.image = image;
        this.quantity = quantity;
    }

    public Item(String item_name, String description, int price, User id_user, int id_category, String image) {
        this.item_name = item_name;
        this.description = description;
        this.price = price;
        this.id_user = id_user;
        this.id_category = id_category;
        this.image = image;
    }

    public Item(int id_item, String item_name, String description, String creation_date, int price, User id_user, int id_category, String image, int quantity) {
        this.id_item = id_item;
        this.item_name = item_name;
        this.description = description;
        this.creation_date = creation_date;
        this.price = price;
        this.id_user = id_user;
        this.id_category = id_category;
        this.image = image;
        this.quantity = quantity;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.id_item != other.id_item) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_category != other.id_category) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.item_name, other.item_name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.creation_date, other.creation_date)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "id_item=" + id_item + ", item_name=" + item_name + ", description=" + description + ", creation_date=" + creation_date + ", price=" + price + ", id_user=" + id_user + ", id_category=" + id_category + ", image=" + image + ", quantity=" + quantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /*  public void getDescription(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getPrice(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
