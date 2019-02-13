package com.am.ramadanseries2019.model;

public class Episode {
    private String id;
    private String title;
    private String eUrl;
    private String imageUrl;

    public Episode() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String geteUrl() {
        return eUrl;
    }

    public void seteUrl(String url) {
        this.eUrl = url;
    }
}
