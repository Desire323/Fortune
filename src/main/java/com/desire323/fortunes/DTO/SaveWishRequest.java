package com.desire323.fortunes.DTO;

public class SaveWishRequest {
    private int userId;
    private String wish;
    private String theme;

    public SaveWishRequest(int userId, String wish, String theme) {
        this.userId = userId;
        this.wish = wish;
        this.theme = theme;
    }

    public SaveWishRequest() {
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
}
