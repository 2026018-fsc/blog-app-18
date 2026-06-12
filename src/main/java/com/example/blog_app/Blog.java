package com.example.blog_app;

public class Blog {
    private final Long id;
    private final String title;
    private final String authorName;
    private final String notes;

    public Blog(Long id,String title, String authorName, String notes) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.notes = notes;        
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthorName() {
        return authorName;
    }
    public String getNotes() {
        return notes;
    }



   
}