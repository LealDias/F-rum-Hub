package com.forumhub.forumhub.dto;

import jakarta.validation.constraints.NotBlank;

public class TopicDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String message;

    @NotBlank
    private String author;

    @NotBlank
    private String course;

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public @NotBlank String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

