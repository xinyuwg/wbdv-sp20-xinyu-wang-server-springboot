package com.example.wbdvsp20xinyuwangserverspringboot.controllers;


import com.example.wbdvsp20xinyuwangserverspringboot.models.Topic;
import com.example.wbdvsp20xinyuwangserverspringboot.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * @author xinyuwang
 */
@RestController
@CrossOrigin(origins = "*")
public class TopicController {
    final
    TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping("/api/topics/{lid}/topics")
    public Topic createTopic(@PathVariable("lid") String lid, Topic topic) {
        return topicService.createTopic(lid, topic);
    }

    @GetMapping("/api/lessons/{lid}/topics")
    public List<Topic> findTopicsForLesson(@PathVariable("lid") String lid) {
        return topicService.findTopicsForLesson(lid);
    }

    @PutMapping("/api/topics/{tid}")
    public int updateTopic(@PathVariable("tid") Integer tid, @RequestBody Topic topic) {
        return topicService.updateTopic(tid, topic);
    }

    @DeleteMapping("/api/topics/{tid}")
    public int deleteTopic(@PathVariable("tid") Integer tid) {
        return topicService.deleteTopic(tid);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopic();
    }

    @GetMapping("/api/topics/{tid}")
    public Topic findTopicById(@PathVariable("tid") Integer tid){
        return topicService.findTopicById(tid);
    }
}
