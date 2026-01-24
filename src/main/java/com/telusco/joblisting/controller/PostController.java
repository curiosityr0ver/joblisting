package com.telusco.joblisting.controller;

import com.telusco.joblisting.entity.Post;
import com.telusco.joblisting.repository.PostRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostRepository repository;

    @Autowired
    MongoTemplate template;


    @GetMapping
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    @GetMapping("/search")
    public List<Post> search(@RequestParam String tech) {

//        List<Post> result = new ArrayList<>();
//        List<Post> allPosts = repository.findAll();
//        for (Post post : allPosts) {
//            for(String t: post.getTech()) {
//                if(t.equalsIgnoreCase(tech)) {
//                    result.add(post);
//                    break;
//                }
//            }
//        }
//        return result;

        return repository.findByTechIgnoreCase(tech);
    }



    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
        return repository.save(post);
    }

//    @GetMapping("/raw")
//    public List<Document> raw() {
//        return template.findAll(Document.class, "JobPost");
//    }
}
