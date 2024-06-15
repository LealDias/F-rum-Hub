package com.forumhub.forumhub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime creationDate; // Corrigido para LocalDateTime

    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(nullable = false)
    private String course;

    // Corrigido método setter para creationDate
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    // Corrigido método setter para status
    public void setStatus(String status) {
        this.status = status;
    }

    // Corrigido método setter para author
    public void setAuthor(User author) {
        this.author = author;
    }

    // Corrigido método setter para course
    public void setCourse(String course) {
        this.course = course;
    }

    public void setTitle(String title) {
    }

    public void setMessage(String message) {
    }

    // getters e outros setters
}