package com.mahmoud.dahdouh.fastfoto.Model;

public class ItemWithFavorite {
    private String name;
    private int image;
    private boolean favorite;

    public ItemWithFavorite() {
    }

    public ItemWithFavorite(String name, int image, boolean favorite) {
        this.name = name;
        this.image = image;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
