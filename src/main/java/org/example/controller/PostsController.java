package org.example.controller;

import org.example.PostDto;
import org.example.client.ServerClient;
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
  List<PostDto> getPosts() {
    return serverClient.getPosts();
  }
}
