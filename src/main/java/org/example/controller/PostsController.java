package org.example.controller;

import org.example.CommentDto;
import org.example.PostDto;
import org.example.client.ServerClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

  final ServerClient serverClient;

  public PostsController(ServerClient serverClient) {
    this.serverClient = serverClient;
  }


  @PostMapping()
  void createPost(@RequestBody PostDto postDto) {
    serverClient.createPost(postDto);
  }

  @PostMapping(path = "{postId}/addComment")
  void addCommentForPost(@RequestBody CommentDto commentDto, @PathVariable long postId) {
    serverClient.createCommentForPost(commentDto, postId);
  }

  @GetMapping()
  List<PostDto> getPosts() {
    return serverClient.getPosts();
  }

  @GetMapping(path = "/{postId}")
  PostDto getPostById(@PathVariable long postId) {
    return serverClient.getPostById(postId);
  }

  @DeleteMapping(path = "/{postId}")
  void deletePostById(@PathVariable long postId) {
    serverClient.deletePostById(postId);
  }
}
