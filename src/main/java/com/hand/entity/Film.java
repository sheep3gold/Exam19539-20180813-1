package com.hand.entity;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 15:18 2018/8/13
 * @ Description：${description}
 * @ Modified By：
 */
public class Film {
    private int film_id;
    private String title;
    private String description;
    private String language;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
