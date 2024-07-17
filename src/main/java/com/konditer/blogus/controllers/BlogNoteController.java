package com.konditer.blogus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konditer.blogus.dto.BlogNoteDto;
import com.konditer.blogus.entities.BlogNote;
import com.konditer.blogus.services.BlogNoteService;
import com.konditer.blogus.services.BlogService;

@RestController
public class BlogNoteController {

    private BlogNoteDto mapBlogNotentityToBlogNoteDto(BlogNote blogNote) {
        return new BlogNoteDto(blogNote.getTitle(), blogNote.getText(),
            blogNote.getPosReactionsAmount(), blogNote.getNegReactionsAmount(),
            blogNote.getBlog().getId(), blogNote.getCreatedAt(), blogNote.getUpdatedAt());
    }

    private BlogNote mapBlogNoteDtoToBlogNoteEntity(BlogNoteDto blogNoteDto) {
        return new BlogNote(blogNoteDto.getTitle(), blogNoteDto.getText(),
            blogService.getBlogById(blogNoteDto.getBlogId()));
    }

    @Autowired
    private BlogNoteService blogNoteService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogNotes/{id}")
    public BlogNoteDto getBlogNoteById(@PathVariable int id) {
        return mapBlogNotentityToBlogNoteDto(blogNoteService.getBlogNoteById(id));
    }

    @GetMapping("/blogNotes")
    public List<BlogNoteDto> getAllBlogNotes() {
        return blogNoteService.getAllBlogNotes()
            .stream().map(c -> mapBlogNotentityToBlogNoteDto(c))
            .collect(Collectors.toList());
    }

    @PostMapping("/blogNotes/register")
    public void registerBlogNote(@RequestBody BlogNoteDto blogNoteDto) {
        System.out.println(blogNoteDto);
        blogNoteService.registerBlogNote(mapBlogNoteDtoToBlogNoteEntity(blogNoteDto));
    }
    
    @DeleteMapping("/blogNotes/{id}")
    public void removeBlogNote(@PathVariable int id) {
        blogNoteService.removeBlogNote(id);
    }

    @GetMapping("/blogNotes/{id}/updateBlogNoteTitle")
    public void updateBlogNoteTitle(@PathVariable int id, @RequestParam String title) {
        blogNoteService.updateBlogNoteTitle(id, title);
    }

    @GetMapping("/blogNotes/{id}/updateBlogNoteText")
    public void updateBlogNoteText(@PathVariable int id, @RequestParam String text) {
        blogNoteService.updateBlogNoteText(id, text);
    }
}
