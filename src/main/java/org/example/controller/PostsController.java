package org.example.controller;

import org.example.client.ServerClient;
import org.example.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

  final ServerClient serverClient;

  public PostsController(ServerClient serverClient) {
    this.serverClient = serverClient;
  }

  @GetMapping(path = "/")
  List<Post> getPosts() {
    return serverClient.getPosts();
  }
}