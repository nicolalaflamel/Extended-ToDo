package com.example.todoapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Boolean completed = false;
    

    @PrePersist
    protected void onCreate() {
    	this.createdAt = LocalDateTime.now();
    }
    
    public String getFormattedCreatedDate() {
    	if (createdAt == null) {
    		return "作成日なし";
    	}
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    			return createdAt.format(formatter);
    }
    		
    public LocalDateTime getCreatedDate() {
    	return createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean isCompleted() {
    	return this.completed;
    }
    
    public void setCompleted(Boolean completed) {
    	this.completed = completed;
    }

}