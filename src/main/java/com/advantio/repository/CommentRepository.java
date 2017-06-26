package com.advantio.repository;

import com.advantio.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by andrey on 23.06.2017.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
}
