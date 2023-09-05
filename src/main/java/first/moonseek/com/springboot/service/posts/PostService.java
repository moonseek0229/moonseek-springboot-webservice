package first.moonseek.com.springboot.service.posts;

import first.moonseek.com.springboot.domain.posts.PostRepository;
import first.moonseek.com.springboot.web.dto.PostsSaveRequestDto;
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

}
