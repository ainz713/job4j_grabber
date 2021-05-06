package ru.job4j.grabber;

import java.time.LocalDateTime;

public class Post {
    private String name;
    private String text;
    private String link;
    private LocalDateTime createddate;

    public Post(String name, String text, String link, LocalDateTime createddate) {
        this.name = name;
        this.text = text;
        this.link = link;
        this.createddate = createddate;
    }
}
