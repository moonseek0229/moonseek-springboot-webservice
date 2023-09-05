package first.moonseek.com.springboot.web;

import first.moonseek.com.springboot.service.posts.PostService;
import first.moonseek.com.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save (@RequestBody PostsSaveRequestDto requestDto){

        return postService.save(requestDto);

    }

}
