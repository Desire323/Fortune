package com.desire323.fortunes.entity;

public class Fortune {
    private int id;
    private String wish;

    public Fortune(int id, String wish) {
        this.id = id;
        this.wish = wish;
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
}
