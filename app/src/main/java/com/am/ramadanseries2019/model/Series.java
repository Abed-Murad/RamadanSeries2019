package com.am.ramadanseries2019.model;

import java.util.List;
import java.util.Map;

public class Series {
    private int id;
    private String name;
    private String posterUrl;
    private String trailerUrl;
    private Map<String, String> airTime;
    private List<Episode> episodeList;


    public Series() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public Map<String, String> getAirTime() {
        return airTime;
    }

    public void setAirTime(Map<String, String> airTime) {
        this.airTime = airTime;
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }
}
