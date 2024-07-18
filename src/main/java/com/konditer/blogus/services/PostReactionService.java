package com.konditer.blogus.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.dto.PostReactionDto;
import com.konditer.blogus.entities.Blog;
import com.konditer.blogus.entities.PostReaction;
import com.konditer.blogus.entities.User;
import com.konditer.blogus.repositories.BlogRepository;
import com.konditer.blogus.repositories.PostReactionRepository;
import com.konditer.blogus.repositories.PostRepository;
import com.konditer.blogus.repositories.UserRepository;
import com.konditer.blogus.services.contracts.PostReactionServiceContract;

@Service
public class PostReactionService implements PostReactionServiceContract {

    final double DEFAULT_REACTION_BLOG_RATING = 0.05;
    final double DEFAULT_REACTION_USER_RATING = 0.05;
    
    @Autowired
    private PostReactionRepository postReactionRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PostReactionDto getReactionById(int id) {
        return mapReactionEntityToReactionDto(postReactionRepository.findById(id).get());
    }

    @Override
    public List<PostReactionDto> getAllReactions() {
        return postReactionRepository.findAll()
            .stream().map(p -> mapReactionEntityToReactionDto(p))
            .collect(Collectors.toList());
    }

    @Override
    public void registerReaction(PostReactionDto reaction) {
        Blog blog = postRepository.findById(reaction.getPostId()).get().getBlog();
        User blogAuthor = blog.getAuthor();

        if (reaction.isPositive()) {
            blog.setRating(blog.getRating() + DEFAULT_REACTION_BLOG_RATING);
            blogAuthor.setRating(blogAuthor.getRating() + DEFAULT_REACTION_USER_RATING);
        } else {
            blog.setRating(blog.getRating() - DEFAULT_REACTION_BLOG_RATING);
            blogAuthor.setRating(blogAuthor.getRating() - DEFAULT_REACTION_USER_RATING);
        }

        blogRepository.save(blog);
        userRepository.save(blogAuthor);
        postReactionRepository.save(mapReacionDtoToReactionEntity(reaction));
    }

    @Override
    public void removeReaction(int id) {
        PostReaction reaction = postReactionRepository.findById(id).get();
        Blog blog = reaction.getPost().getBlog();
        User blogAuthor = blog.getAuthor();

        if (reaction.isPositive()) {
            blog.setRating(blog.getRating() - DEFAULT_REACTION_BLOG_RATING);
            blogAuthor.setRating(blogAuthor.getRating() - DEFAULT_REACTION_USER_RATING);
        } else {
            blog.setRating(blog.getRating() + DEFAULT_REACTION_BLOG_RATING);
            blogAuthor.setRating(blogAuthor.getRating() + DEFAULT_REACTION_USER_RATING);
        }

        blogRepository.save(blog);
        userRepository.save(blogAuthor);
        postReactionRepository.deleteById(id);
    }

    @Override
    public List<PostReactionDto> getReactionByCommentIdAndPositive(int id, boolean positive) {
        return postReactionRepository.findByPostIdAndPositive(id, positive)
            .stream().map(r -> mapReactionEntityToReactionDto(r))
            .collect(Collectors.toList());
    }

    private PostReactionDto mapReactionEntityToReactionDto(PostReaction reaction) {
        return new PostReactionDto(reaction.isPositive(), 
            reaction.getAuthor().getId(), 
            reaction.getPost().getId(), 
            reaction.getAuthor().getName(), 
            reaction.getPost().getTitle(),
            reaction.getCreatedAt(), 
            reaction.getUpdatedAt());
    }

    private PostReaction mapReacionDtoToReactionEntity(PostReactionDto reactionDto) {
        return new PostReaction(reactionDto.isPositive(),
            userRepository.findById(reactionDto.getAuthorId()).get(),
            postRepository.findById(reactionDto.getPostId()).get());
    }
}
