package ru.job4j.grabber;

import java.time.LocalDateTime;

public class Post {
    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    private int id;
    private String name;
    private String text;

    public void setId(int id) {
        this.id = id;
    }

    private String link;
    private LocalDateTime createdDate;

    public Post() {

    }

    public int getId() {
        return id;
    }

    public Post(String name, String text, String link, LocalDateTime createdDate) {
        this.name = name;
        this.text = text;
        this.link = link;
        this.createdDate = createdDate;
    }

    public Post(int id, String name, String description, String link, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.text = description;
        this.link = link;
        this.createdDate = createDate;
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
