package com.example.blog_app;

public class BlogForm {
    private Long id;
    private String title;
    private String authorName;
    private String notes;

    public BlogForm(){

    }

    public BlogForm(Long id,String title, String authorName, String notes) {
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

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }


   
}