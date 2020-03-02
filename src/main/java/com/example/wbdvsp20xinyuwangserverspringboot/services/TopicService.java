package com.example.wbdvsp20xinyuwangserverspringboot.services;

import com.example.wbdvsp20xinyuwangserverspringboot.models.Topic;
import com.example.wbdvsp20xinyuwangserverspringboot.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author xinyuwang
 */
@Service
public class TopicService {

    final
    TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> findAllTopic() {
        return (List<Topic>) topicRepository.findAll();
    }

    public List<Topic> findTopicsForLesson(String lessonId) {
        return topicRepository.findTopicsForLesson(lessonId);
    }

    public Topic createTopic(String lessonId, Topic newTopic) {
        newTopic.setLessonId(lessonId);
        return topicRepository.save(newTopic);
    }

    public int updateTopic(Integer topicId, Topic newTopic) {
        try {
            newTopic.setId(topicId);
            topicRepository.save(newTopic);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int deleteTopic(Integer topicId) {
        try {
            topicRepository.deleteById(topicId);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public Topic findTopicById(Integer topicId) {
        Optional<Topic> topicOptional = topicRepository.findById(topicId);
        return topicOptional.orElseGet(Topic::new);
    }

}
