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
        musics.put("35847388","http://m10.music.126.net/20180616211839/1db65f136ab6f94b95da4748b3e40c9e/ymusic/de9a/6885/e183/effb8f74546c98fd619d51f22e2bfaaf.mp3");
    }
}
