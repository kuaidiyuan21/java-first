package com.qingguatang.java5minute.course6;


import com.qingguatang.java5minute.course4.model.Comment;
import com.qingguatang.java5minute.course5.commentPostControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentLikeControl {

    @Autowired
    private commentPostControl commentPostControl;

    @RequestMapping(value = "/comment/like")
    @ResponseBody
    public Comment like(@RequestParam(value = "songId") String songId,@RequestParam(value = "commentId") String commentId) {

        List<Comment> commentList = commentPostControl.getComments(songId);
        Comment result = null;
        for (Comment comment : commentList) {
            if (!comment.getId().equals(commentId)) {
                continue;
            }
            comment.setLikeNum(comment.getLikeNum() + 1);
            result = comment;
        }
        return result;
    }

}
