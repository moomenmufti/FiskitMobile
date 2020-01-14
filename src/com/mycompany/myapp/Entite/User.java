/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entite;


import java.util.Objects;

/**
 *
 * @author zomra
 */
public class User {

    private int id_user;
    private String username;
    private String name;
    private String last_name;
    private String address;
    private String photo;
    private String location;
    private int cin;
    private String date_of_birth;
    private String email;
    private int role;
    private Float balance;
    private String password;
    public int get;

    public User() {
    }

    public User(int id_user, String username, String name, String last_name, String address, String photo, String location, int cin, String date_of_birth, String email, int role, Float balance, String password) {
        this.id_user = id_user;
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.photo = photo;
        this.location = location;
        this.cin = cin;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.role = role;
        this.balance = balance;
        this.password = password;
    }

    public User(String username, String name, String last_name, String address, String photo, String location, int cin, String date_of_birth, String email, int role, Float balance, String password) {
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.photo = photo;
        this.location = location;
        this.cin = cin;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.role = role;
        this.balance = balance;
        this.password = password;
    }

    public User(String username, String name, String last_name, String address, String photo, int cin, String date_of_birth, String email, String password) {
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.photo = photo;
        this.cin = cin;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.password = password;
    }

    public User(String username, String name, String last_name, String address, String photo, String location, int cin, String date_of_birth, String email, String password, Float balance) {
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.photo = photo;
        this.location = location;
        this.cin = cin;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public User(String username, String name, String last_name, String address, int cin, String email, String password) {
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.cin = cin;
        this.email = email;
        this.password = password;
    }

    public User(String username, String name, String last_name, String address, String photo, int cin, String email, String password) {
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.photo = photo;
        this.cin = cin;
        this.email = email;
        this.password = password;
    }

    public User(String username, String name, String last_name, String address, String photo, int cin, String email, int role, String password) {
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.photo = photo;
        this.cin = cin;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User(String username, String name, String last_name, String address, String photo, int cin, String date_of_birth, String email, int role, String password) {
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.photo = photo;
        this.cin = cin;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", username=" + username + ", name=" + name + ", last_name=" + last_name + ", address=" + address + ", photo=" + photo + ", location=" + location + ", cin=" + cin + ", date_of_birth=" + date_of_birth + ", email=" + email + ", role=" + role + ", balance=" + balance + ", password=" + password + '}';
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
        final User other = (User) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.cin != other.cin) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.date_of_birth, other.date_of_birth)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        return true;
    }

}
