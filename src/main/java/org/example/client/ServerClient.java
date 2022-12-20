package org.example.client;

import org.example.data.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "serverApp", url = "http://localhost:8081/")
public interface ServerClient {

  @GetMapping(value = "/posts/")
  List<Post> getPosts();
}
