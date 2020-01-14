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
public class Cart {

    private int id_cart;
    private int id_item;
    private User id_user;
    private String image;
    private String item_name;
    private int price;
    private int quantity;
    private int total;

    public Cart() {
    }

    public Cart(int id_cart, int id_item, User id_user, String image, String item_name, int price, int quantity, int total) {
        this.id_cart = id_cart;
        this.id_item = id_item;
        this.id_user = id_user;
        this.image = image;
        this.item_name = item_name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public Cart(int id_item, User id_user, String image, String item_name, int price, int quantity, int total) {
        this.id_item = id_item;
        this.id_user = id_user;
        this.image = image;
        this.item_name = item_name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Cart other = (Cart) obj;
        if (this.id_cart != other.id_cart) {
            return false;
        }
        if (this.id_item != other.id_item) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.total != other.total) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.item_name, other.item_name)) {
            return false;
        }
        return true;
    }

}
