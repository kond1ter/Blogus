package com.konditer.blogus.services.contracts;

import java.util.List;

import com.konditer.blogus.entities.BlogNote;

public interface BlogNoteServiceContract {
    
    BlogNote getBlogNoteById(int id);

    List<BlogNote> getAllBlogNotes();

    void registerBlogNote(BlogNote blogNote);

    void removeBlogNote(int id);

    void updateBlogNoteTitle(int id, String title);

    void updateBlogNoteText(int id, String text);
}
