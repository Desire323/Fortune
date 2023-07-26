package com.desire323.fortunes.entity;

public class Fortune {
    private int id;
    private String wish;
    private String theme;

    public Fortune(int id, String wish, String theme) {
        this.id = id;
        this.wish = wish;
        this.theme = theme;
    }

    public Fortune() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
