package com.mahmoud.dahdouh.fastfoto.Model;

public class OnboardingModel {
    private String titile;
    private String description;
    private int image;

    public OnboardingModel(String titile, String description, int image) {
        this.titile = titile;
        this.description = description;
        this.image = image;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
