/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Objects;

/**
 *
 * @author zomra
 */
public class Events {
    private int id_event;
    private String title;
    private String description;
    private String photo;
    private String date;
    private String place;
    private int vacancies;
    private int capacity;

    public Events() {
    }

    public Events(int id_event, String title, String description, String photo, String date, String place, int vacancies, int capacity) {
        this.id_event = id_event;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.date = date;
        this.place = place;
        this.vacancies = vacancies;
        this.capacity = capacity;
    }

    public Events(String title, String description, String photo, String date, String place, int vacancies, int capacity) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.date = date;
        this.place = place;
        this.vacancies = vacancies;
        this.capacity = capacity;
    }

    public Events(int vacancies) {
        this.vacancies = vacancies;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getVacancies() {
        return vacancies;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Events{" + "id_event=" + id_event + ", title=" + title + ", description=" + description + ", photo=" + photo + ", date=" + date + ", place=" + place + ", vacancies=" + vacancies + ", capacity=" + capacity + '}';
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
        final Events other = (Events) obj;
        if (this.id_event != other.id_event) {
            return false;
        }
        if (this.vacancies != other.vacancies) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.place, other.place)) {
            return false;
        }
        return true;
    }
}
