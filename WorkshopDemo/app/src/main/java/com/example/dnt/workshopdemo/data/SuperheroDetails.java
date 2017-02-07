package com.example.dnt.workshopdemo.data;

/**
 * Created by dnt on 7.2.2017 г..
 */

public class SuperheroDetails extends Superhero {

    private String story;
    private String[] powers;
    private String[] fractions;

    SuperheroDetails(String name, String imageUrl, String secretIdentity, int id, String story, String[] powers, String[] fractions) {
        super(name, imageUrl, secretIdentity, id);

        this.setStory(story);
        this.setPowers(powers);
        this.setFractions(fractions);

    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String[] getPowers() {
        return powers;
    }

    public void setPowers(String[] powers) {
        this.powers = powers;
    }

    public String[] getFractions() {
        return fractions;
    }

    public void setFractions(String[] fractions) {
        this.fractions = fractions;
    }
}
