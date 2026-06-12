package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> findAll (){
        return blogRepository.findAll();
    }

    public Optional <Blog> findById (Long id){
        return blogRepository.findById(id);
    }

    public void save(BlogForm form){
      blogRepository.save(new Blog (null, form.getTitle(),form.getAuthorName(),form.getNotes()));
    }
public void delete(Long id) {
  blogRepository.deleteById(id);
}
public void update(Long id, BlogForm form) {
  blogRepository.update(id, form.getTitle(), form.getAuthorName(),form.getNotes());
}

}
