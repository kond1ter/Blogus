package com.konditer.blogus.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konditer.blogus.entities.BlogNote;
import com.konditer.blogus.repositories.BlogNoteRepository;
import com.konditer.blogus.services.contracts.BlogNoteServiceContract;

@Service
public class BlogNoteService implements BlogNoteServiceContract {

    @Autowired
    private BlogNoteRepository blogNoteRepository;

    @Override
    public BlogNote getBlogNoteById(int id) {
        return blogNoteRepository.findById(id);
    }

    @Override
    public List<BlogNote> getAllBlogNotes() {
        return blogNoteRepository.findAll();
    }

    @Override
    public void registerBlogNote(BlogNote blogNote) {
        blogNoteRepository.save(blogNote);
    }

    @Override
    public void removeBlogNote(int id) {
        blogNoteRepository.delete(blogNoteRepository.findById(id));
    }

    @Override
    public void updateBlogNoteTitle(int id, String title) {
        BlogNote blogNote = blogNoteRepository.findById(id);
        blogNote.setTitle(title);
        blogNote.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blogNoteRepository.save(blogNote);
    }

    @Override
    public void updateBlogNoteText(int id, String text) {
        BlogNote blogNote = blogNoteRepository.findById(id);
        blogNote.setText(text);
        blogNote.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blogNoteRepository.save(blogNote);
    }
    
}
