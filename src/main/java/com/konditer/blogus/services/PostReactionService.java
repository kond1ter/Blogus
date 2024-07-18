package com.konditer.blogus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.Blog;
import com.konditer.blogus.entities.PostReaction;
import com.konditer.blogus.entities.User;
import com.konditer.blogus.repositories.BlogRepository;
import com.konditer.blogus.repositories.PostReactionRepository;
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
    private UserRepository userRepository;

    @Override
    public PostReaction getReactionById(int id) {
        return postReactionRepository.findById(id).get();
    }

    @Override
    public List<PostReaction> getAllReactions() {
        return postReactionRepository.findAll();
    }

    @Override
    public void registerReaction(PostReaction reaction) throws NotFoundException {
        Blog blog = reaction.getPost().getBlog();
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
        postReactionRepository.save(reaction);
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
    public List<PostReaction> getReactionByCommentIdAndPositive(int id, boolean positive) {
        return postReactionRepository.findByPostIdAndPositive(id, positive);
    }
}
