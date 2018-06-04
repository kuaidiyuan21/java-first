package com.qingguatang.java5minute.course4;

import com.qingguatang.java5minute.course4.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentControl {

    @RequestMapping(value = "/comments")
    public String comments(ModelMap modelMap){

        List<Comment> comments = getComment();

        modelMap.addAttribute("comments",comments);

        return  "comments";
    }

    private List<Comment> getComment(){

        List<Comment> comments = new ArrayList<>();

        Comment comment = new Comment();
        comment.setIcon("http://p1.music.126.net/fQPcNZ7yTMMRkBIobpgiXw==/109951163284896187.jpg?param=50y50");
        comment.setNickName("Notearslefttocry");
        comment.setContent("hello！一转眼四年了！终于等到王者的归来~阿呆的全球屠榜又要开始啦！在此献上我的鸡腿！嘻嘻~");
        comment.setCommentTime("2015年10月23日");
        comment.setLikeNum(82770);
        comments.add(comment);

        comment = new Comment();
        comment.setIcon("http://p1.music.126.net/eLZfXg6oY_xqWmd3hzQg-w==/109951163043012263.jpg?param=50y50");
        comment.setNickName("Edawn");
        comment.setContent("这hello应该翻译成别来无恙更恰当。");
        comment.setCommentTime("2015年12月13日");
        comment.setLikeNum(64145);
        comments.add(comment);

        return comments;
    }

}
