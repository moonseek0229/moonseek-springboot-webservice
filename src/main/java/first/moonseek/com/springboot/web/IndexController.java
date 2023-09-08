package first.moonseek.com.springboot.web;

import first.moonseek.com.springboot.service.posts.PostService;
import first.moonseek.com.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index (Model model){
        model.addAttribute("posts" , postService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {

        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsupdate (@PathVariable Long id, Model model){
        PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}