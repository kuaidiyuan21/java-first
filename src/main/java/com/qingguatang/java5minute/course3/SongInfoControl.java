package com.qingguatang.java5minute.course3;

import com.qingguatang.java5minute.course3.model.SongInfo;
import com.qingguatang.java5minute.course4.CommentControl;
import com.qingguatang.java5minute.course4.model.Comment;
import com.qingguatang.java5minute.course5.commentPostControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SongInfoControl {

    private static Map<String,SongInfo> songInfoMap = new HashMap<>();

@Autowired
private commentPostControl commentPostControl;


    @RequestMapping(value = "/songinfo")
    public String index(String songId,ModelMap modelMap){

        if (songId == null) {
            songId = "35847388";
        }
        SongInfo songInfo = songInfoMap.get(songId);
        modelMap.addAttribute("song",songInfo);

        List<Comment> comments = commentPostControl.getComments(songId);

        modelMap.addAttribute("comments",comments);

        return "index";
    }

    @RequestMapping(value = "/songinfo/get")
    @ResponseBody
    public SongInfo get(String songId) {
        SongInfo songInfo = songInfoMap.get(songId);
        return songInfo;
    }

    @PostConstruct
    public void init(){

        //hello这首歌
        SongInfo songInfo = new SongInfo();
        songInfo.setId("35847388");
        songInfo.setName("Hello");
        songInfo.setSinger("Adele");
        songInfo.setAlbumName("Hello");
        songInfo.setCommentCount(10);
        songInfo.setAlbumImg("http://p1.music.126.net/PrO7oPvnjvH4xdujdGbf2w==/1407374890649284.jpg?param=130y130");
        songInfo.setLyrics("Hello, it's me <br/> 你好吗 是我 <br/> I was wondering if after all these years you'd like to meet <br/> 我犹豫着要不要给你来电 不确定多年后你是否还愿相见 <br/>");
        songInfoMap.put("35847388",songInfo);

        songInfo = new SongInfo();
        songInfo.setId("16435049");
        songInfo.setName("Someone Like You");
        songInfo.setSinger("Adele");
        songInfo.setAlbumName("Someone Like You");
        songInfo.setAlbumImg("http://p1.music.126.net/-g2ieFBmoy7T8crwFaAdxQ==/109951163077007716.jpg?param=130y130");
        songInfo.setLyrics("I heard <br/>听说<br/> That you are settled down");
        songInfoMap.put("16435049",songInfo);
    }
}
