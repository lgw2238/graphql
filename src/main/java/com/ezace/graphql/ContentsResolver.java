package com.ezace.graphql;


import com.ezace.domain.User;
import com.ezace.domain.Contents;
import com.ezace.repository.UserRepository;
import com.ezace.repository.ContentsRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentsResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final ContentsRepository contentsRepository;

    public List<Contents> getAllContents() {
        return contentsRepository.findAll();
    }

    public Contents getContents(int idx) {
        return contentsRepository.findByIdx(idx);
    }

    public Contents createContents(String title, String content, String category, int userIdx) {
        //user
        User findUser = userRepository.findByIdx(userIdx);

        //contents
        Contents contents = Contents.builder()
                .title(title)
                .contents(content)
                .category(category)
                .user(findUser)
                .build();
        contents = contentsRepository.save(contents);

        return contents;
    }

    public Contents updateContentsTitle(int idx, String title) {
        
    	Contents contents = contentsRepository.findByIdx(idx);

        //update title
    	contents.setTitle(title);
    	contents = contentsRepository.save(contents);

        return contents;
    }
    
    
    public Contents deleteContents(int idx) {
        
    	Contents contents = contentsRepository.findByIdx(idx);

        //update title
    	contents.setUseyn("N");
    	contents = contentsRepository.save(contents);

        return contents;
    }
}
