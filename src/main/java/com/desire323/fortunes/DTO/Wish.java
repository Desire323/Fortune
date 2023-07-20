package com.desire323.fortunes.DTO;

public class Wish {
    private int id;
    private String wish;

    public Wish(int id, String wish) {
        this.id = id;
        this.wish = wish;
    }

    public Wish() {
    }

    public int getId() {
        return id;
    }

    public String getWish() {
        return wish;
    }
}
