package com.feeham.frontendserver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private static final List<Post> posts = new ArrayList<Post>();
    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(posts);
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@RequestParam Integer id){
        Optional<Post> post = posts.stream().filter(p -> p.getId() == id).findFirst();
        if(post.isEmpty()){
            return new ResponseEntity<>("Post with given ID doesn't exist", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(post.get());
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
        return ResponseEntity.ok("Post created successfully");
    }
}
