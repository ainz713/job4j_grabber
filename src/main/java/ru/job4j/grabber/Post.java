package ru.job4j.grabber;

import java.time.LocalDateTime;

public class Post {
    private String name;
    private String text;
    private String link;
    private LocalDateTime createdDate;

    public Post(String name, String text, String link, LocalDateTime createddate) {
        this.name = name;
        this.text = text;
        this.link = link;
        this.createdDate = createddate;
    }

    @Override
    public String toString() {
        return "Post{"
                + "name='" + name + '\'' + System.lineSeparator()
                + ", text='" + text + '\'' + System.lineSeparator()
                + ", link='" + link + '\'' + System.lineSeparator()
                + ", createdDate=" + createdDate
                + '}';
    }
}
