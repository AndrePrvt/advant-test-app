package com.advantio.model.DTO;

import com.advantio.model.Comment;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

/**
 * Created by andrey on 22.06.2017.
 */
public class CommentDTO {
    @JsonView
    private int comment_id;
    @JsonView
    private String text;
    @JsonView
    private Date date;
    @JsonView
    private int blog_id;
    @JsonView
    private String email;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public CommentDTO(){

    }
    public CommentDTO(Comment comment){
        this.comment_id = comment.getCommentId();
        this.text = comment.getText();
        this.date = comment.getDate();
        this.email = comment.getEmail();
        this.blog_id = comment.getBlog().getBlogId();
    }

    public Comment toComment(){
        Comment comment = new Comment();
        comment.setEmail(this.getEmail());
        comment.setDate(this.getDate());
        comment.setText(this.getText());
        comment.setCommentId(this.comment_id);
        return comment;
    }
}
