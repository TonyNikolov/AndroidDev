package com.example.dnt.welcomescreenwithanimation.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dnt on 24.1.2017 г..
 */

public class Animal implements Parcelable{
    private String name;
    private String species;
    private String description;
    private String thumbnail;
    private String image;

    public Animal(){

    }

    public Animal(String name, String species, String description, String thumbnail, String image){
        this.setName(name);
        this.setSpecies(species);
        this.setDescription(description);
        this.setImage(image);
        this.setThumbnail(thumbnail);
    }

    public Animal(Parcel source){
        setName(source.readString());
        setSpecies(source.readString());
        setDescription(source.readString());
        setThumbnail(source.readString());
        setImage(source.readString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        applyDefaultValues();
        dest.writeString(name);
        dest.writeString(species);
        dest.writeString(description);
        dest.writeString(thumbnail);
        dest.writeString(image);
    }

    private void applyDefaultValues(){
        if(name==null){
            name="";
        }
        if(species==null){
            species="";
        }if(description==null){
            description="";
        }
        if(thumbnail==null){
            thumbnail="";
        }if(image==null){
            image="";
        }
    }

    public static Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel source) {
            return new Animal(source);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };
}
