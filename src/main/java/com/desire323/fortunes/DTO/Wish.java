package com.desire323.fortunes.DTO;

public class Wish {
    private String wish;
    private String theme;

    public Wish(String wish, String theme) {
        this.wish = wish;
        this.theme = theme;
    }

    public Wish() {
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