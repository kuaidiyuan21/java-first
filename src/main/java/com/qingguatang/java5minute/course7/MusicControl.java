package com.qingguatang.java5minute.course7;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MusicControl {
    private static final Map<String, String> musics = new HashMap<>();

    @RequestMapping(value = "/song/music")
    @ResponseBody
    public String getMusicSrc(String songId) { return musics.get(songId); }
    @PostConstruct
    public void init(){
        musics.put("35847388","http://m10.music.126.net/20180620181350/bcb34dbbfad40ef5dcd7d5c6ab8bd115/ymusic/de9a/6885/e183/effb8f74546c98fd619d51f22e2bfaaf.mp3");
        musics.put("16435049","http://m10.music.126.net/20180620203014/5de3ba46f8003d34f1f02583f4dbca20/ymusic/0cce/0768/52ed/db86bd40d6ba02bc4dc09cc942216662.mp3");
    }
}
