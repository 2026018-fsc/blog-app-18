package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
    private final JdbcClient jdbcClient;

    public BlogRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Blog> findAll() {
        return jdbcClient.sql("SELECT id,title,authorName,notes FROM Blogs")
                .query(Blog.class)
                .list();
    }

    public Optional<Blog> findById(Long id) {
        return jdbcClient.sql("SELECT id,title,authorName,notes FROM Blogs WHERE id =:id")
                .param("id", id)
                .query(Blog.class)
                .optional();
    }

    public void save(Blog blog) {
        jdbcClient.sql("INSERT INTO Blogs(title,authorName,notes) VALUES (:title,:authorName,:notes)")
                .param("title", blog.getTitle())
                .param("authorName", blog.getAuthorName())
                .param("notes", blog.getNotes())
                .update();
    }

    public void deleteById(Long id) {
  jdbcClient.sql("DELETE FROM Blogs WHERE id = :id")
      .param("id", id)
      .update();
}

public void update(Long id, String title, String authorName, String notes) {
  jdbcClient.sql("UPDATE Blogs SET title = :title, authorName = :authorName,notes = :notes WHERE id = :id")
      .param("title", title)
      .param("authorName", authorName)
      .param("notes",notes)
      .param("id", id)
      .update();
}
}
