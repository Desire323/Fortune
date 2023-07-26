package com.desire323.fortunes.entity;

import java.time.Instant;

public class HistoryFortune{
    private int userId;
    private String wish;
    private String theme;
    private Instant date;

    public HistoryFortune(int userId, String wish, String theme, Instant date) {
        this.userId = userId;
        this.wish = wish;
        this.theme = theme;
        this.date = date;
    }

    public HistoryFortune() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}