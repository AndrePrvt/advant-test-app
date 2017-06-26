package com.advantio.service;

import com.advantio.model.Blog;
import com.advantio.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrey on 23.06.2017.
 */


public interface MainService {
    Blog saveBlog(Blog blog) throws Exception;
    Comment saveCommentInBlog(Comment comment, int blogId) throws Exception;
    List<Blog> getAllBlogs() throws Exception;
    Blog getBlog(int id) throws Exception;
    List <Comment> getCommentsInBlog(int blogId) throws Exception;
    Blog updateBlog(Blog blog) throws Exception;
    Comment updateCommentInBlog(int blogId, Comment comment) throws Exception;
    void deleteCommentInBlog(int commentId) throws Exception;
}
