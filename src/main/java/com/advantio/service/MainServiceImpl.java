package com.advantio.service;

import com.advantio.model.Blog;
import com.advantio.model.Comment;
import com.advantio.repository.BlogRepository;
import com.advantio.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 23.06.2017.
 */
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Blog saveBlog(Blog blog) {
       return blogRepository.save(blog);
    }

    @Override
    @Transactional
    public Comment saveCommentInBlog(Comment comment, int blogId) {
        Blog blog = blogRepository.findOne(blogId);
        comment.setBlog(blog);
        return commentRepository.save(comment);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlog(int id) {
        return blogRepository.findOne(id);
    }

    @Override
    public List<Comment> getCommentsInBlog(int blogId) {
        Blog blog = blogRepository.findOne(blogId);
        return blog.getComments();
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    @Transactional
    public Comment updateCommentInBlog(int blogId, Comment comment) {
        Blog blog = blogRepository.findOne(blogId);
        comment.setBlog(blog);
        return commentRepository.save(comment);
    }

    @Override
    public void deleteCommentInBlog(int commentId) {
         commentRepository.delete(commentId);
    }
}
