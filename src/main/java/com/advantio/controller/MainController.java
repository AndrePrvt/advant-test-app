package com.advantio.controller;

/**
 * Created by andrey on 23.06.2017.
 */

import com.advantio.model.Blog;
import com.advantio.model.Comment;
import com.advantio.model.DTO.BlogDTO;
import com.advantio.model.DTO.CommentDTO;
import com.advantio.service.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class MainController {

    @Autowired
    MainServiceImpl service;


    @RequestMapping(value ="/blog", method= RequestMethod.POST)
    public BlogDTO setBlog(@RequestBody BlogDTO blogDTO){
        System.out.println("Controller /blog invoked");
        Blog blog = blogDTO.toBlog();
        try {
            blogDTO = new BlogDTO(service.saveBlog(blog));
        }catch (Exception e){
            e.printStackTrace();
        }
        return blogDTO;
    }

    @RequestMapping(value= "/blog/{id}", method= RequestMethod.GET)
    public BlogDTO getBlog(@PathVariable(value="id") int id){
        System.out.println("Controller /blog invoked");
        BlogDTO blogDTO= new BlogDTO();
        try {
            blogDTO = new BlogDTO(service.getBlog(Integer.valueOf(id)));
        }catch (Exception e){
            e.printStackTrace();
        }

        return blogDTO;
    }

    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public List<BlogDTO> getBlogs(){
        List<BlogDTO> blogEntryDTOs = new ArrayList<>();
        try{
            List<Blog> blogEntries = service.getAllBlogs();
            for(Blog be: blogEntries){
                BlogDTO blogEntryDTO = new BlogDTO(be);
                blogEntryDTOs.add(blogEntryDTO);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return blogEntryDTOs;
    }

    @RequestMapping(value= "/blog/{id}/comment", method =RequestMethod.POST)
    public CommentDTO setBlogComment(@RequestBody CommentDTO commentDTO, @PathVariable(value="id") int id){
        try {
            service.saveCommentInBlog(commentDTO.toComment(), Integer.valueOf(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return commentDTO;
    }

    @RequestMapping(value= "/blog/{id}/comments", method = RequestMethod.GET)
    public List<CommentDTO> getCommentsByBlog( @PathVariable(value="id") int id){
        List<CommentDTO> commentDTOList = new ArrayList<>();
        try{
            List<Comment> comments  = service.getCommentsInBlog(id);
            for(Comment comment : comments){
                commentDTOList.add(new CommentDTO(comment));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return commentDTOList;
    }

    @RequestMapping(value= "/blogEntry/{id}", method = RequestMethod.PUT)
    public BlogDTO updateBlog(@RequestBody BlogDTO blogEntryDTO){
        try {
            service.updateBlog(blogEntryDTO.toBlog());
        }catch (Exception e){
            e.printStackTrace();
        }
        return blogEntryDTO;
    }

    @RequestMapping(value= "/blog/{blog_id}/comment/}", method =RequestMethod.POST)
    public CommentDTO updateBlogComment(@RequestBody CommentDTO commentDTO,  @PathVariable(value="blog_id") int blog_id){
        try{
            service.updateCommentInBlog(blog_id, commentDTO.toComment());
        }catch(Exception e){
            e.printStackTrace();
        }
        return commentDTO;
    }

    @RequestMapping(value= "comment/{comment_id}", method =RequestMethod.DELETE)
    public CommentDTO deleteBlogComment(@PathVariable(value="comment_id") int comment_id){
        try {
            service.deleteCommentInBlog(comment_id);
        }catch (Exception e){

        }
        return new CommentDTO();
    }

}

