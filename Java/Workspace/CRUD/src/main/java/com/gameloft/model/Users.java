/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.model;

/**
 *
 * @author Kitajima2910
 */
public class Users {

    private long id;
    private String name;
    private String email;
    private String country;
    private String password;

    public Users() {

    }

    public Users(String name, String email, String country, String password) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
        this.password = password;
    }
    
    public Users(long id, String name, String email, String country, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users [id=" + id + ", name=" + name + ", email=" + email + ", country=" + country + ", password="
                + password + "]";
    }

}
