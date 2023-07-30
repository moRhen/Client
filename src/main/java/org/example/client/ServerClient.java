package org.example.client;

import org.example.CommentDto;
import org.example.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "serverApp", url = "http://localhost:8081/")
public interface ServerClient {


  @PostMapping(value = "/posts")
  void createPost(@RequestBody PostDto postDto);

  @PostMapping(value = "/comments/{postId}")
  void createCommentForPost(@RequestBody CommentDto commentDto, @PathVariable long postId);

  @GetMapping(value = "/posts")
  List<PostDto> getPosts();

  @GetMapping(value = "/posts/{postId}")
  PostDto getPostById(@PathVariable long postId);

  @DeleteMapping(value = "/posts/{postId}")
  void deletePostById(@PathVariable long postId);
}
