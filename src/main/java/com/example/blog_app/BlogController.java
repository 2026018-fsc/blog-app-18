package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BlogController {

    private final BlogService blogService;
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public String blog(Model model) {
        List<Blog>blogs = blogService.findAll();
        model.addAttribute("blogs",blogs);
        return "blogs";
    }
    
    @GetMapping("/blogs/{id}")
    public String detail(@PathVariable Long id,Model model) {
        Optional<Blog> blogOpt =blogService.findById(id);
        if(blogOpt.isEmpty()){
            return "redirect:/blogs";
        }
        model.addAttribute("blog",blogOpt.get());
        return "blog/new";
    }

       @GetMapping("/newblog")
    public String newBlog() {
        return "newblog";
    }

    @PostMapping("/blogs")
    public String saveForm(@ModelAttribute BlogForm form) {
        blogService.save(form);
        return "redirect:/blogs";
    }

    @PostMapping("/blogs/{id}/delete")
public String delete(@PathVariable Long id) {
  blogService.delete(id);
  return "redirect:/blogs";
}
@GetMapping("/blogs/{id}/edit")
public String editForm(@PathVariable Long id, Model model) {
  Optional<Blog> blogOpt = blogService.findById(id);
  if (blogOpt.isEmpty()) {
    return "redirect:/blogs";
  }
  Blog blog = blogOpt.get();

  BlogForm form = new BlogForm();
  form.setTitle(blog.getTitle());
  form.setAuthorName(blog.getAuthorName());
  form.setNotes(blog.getNotes());
  model.addAttribute("blogForm", form);
  model.addAttribute("blogId", id);
  return "blog/edit";
}

@PostMapping("/blogs/{id}/update")
public String update(@PathVariable Long id, @ModelAttribute BlogForm form) {
  blogService.update(id, form);
  return "redirect:/blogs";
}



    
}
