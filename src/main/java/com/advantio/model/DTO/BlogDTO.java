package com.advantio.model.DTO;

import com.advantio.model.Blog;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

/**
 * Created by andrey on 22.06.2017.
 */
public class BlogDTO {

    @JsonView
    private int blog_id;
    @JsonView
    private String text;
    @JsonView
    private Date date;
    @JsonView
    private String email;

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BlogDTO(Blog blog){
        this.blog_id = blog.getBlogId();
        this.text = blog.getText();
        this.date = blog.getDate();
        this.email =blog.getEmail();
    }

    public BlogDTO(){

    }

    public Blog toBlog(){
        Blog blog = new Blog();
        blog.setBlogId(this.getBlog_id());
        blog.setText(this.getText());
        blog.setDate(this.getDate());
        blog.setEmail(this.getEmail());
        return blog;
    }
}
