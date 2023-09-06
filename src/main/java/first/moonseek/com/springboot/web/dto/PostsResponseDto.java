package first.moonseek.com.springboot.web.dto;

import first.moonseek.com.springboot.domain.posts.Posts;
import lombok.Getter;

import java.security.PrivateKey;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getTitle();
        this.author = entity.getAuthor();
    }

}
