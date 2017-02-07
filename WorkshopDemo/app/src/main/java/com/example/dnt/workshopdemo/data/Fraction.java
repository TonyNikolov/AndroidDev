package com.example.dnt.workshopdemo.data;

/**
 * Created by dnt on 7.2.2017 г..
 */

public class Fraction {
    public String name;
    public String imageUrl;
    public String secretIdentity;
    public int id;

    Fraction(String name, String imageUrl, String secretIdentity, int id) {
        this.name = name;
        this.secretIdentity = secretIdentity;
        this.imageUrl = imageUrl;
        this.id = id;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretIdentity() {
        return this.secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
