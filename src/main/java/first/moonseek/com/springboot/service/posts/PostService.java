package first.moonseek.com.springboot.service.posts;

import first.moonseek.com.springboot.domain.posts.PostRepository;
import first.moonseek.com.springboot.domain.posts.Posts;
import first.moonseek.com.springboot.web.dto.PostsResponseDto;
import first.moonseek.com.springboot.web.dto.PostsSaveRequestDto;
import first.moonseek.com.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save (PostsSaveRequestDto requestDto){

        return postRepository.save(requestDto.ToEntity()).getId();

    }

    @Transactional
    public Long update (Long id, PostsUpdateRequestDto requestDto ){
        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 업습니다. id=" + id ));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById ( Long id ){
        Posts entity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id" + id));

        return new PostsResponseDto(entity);

    }

}
