package com.mieleria.service;

import com.mieleria.models.Comment;
import com.mieleria.repository.CommentRepository;
import java.util.List;

public class CommentService {

    private CommentRepository commentRepository = new CommentRepository();

    public void createComment(Comment comment) {
        commentRepository.create(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(int id) {
        return commentRepository.findById(id);
    }

    public void updateComment(Comment comment) {
        commentRepository.update(comment);
    }

    public void deleteComment(int id) {
        commentRepository.delete(id);
    }
}
