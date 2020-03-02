package com.example.wbdvsp20xinyuwangserverspringboot.repositories;

import com.example.wbdvsp20xinyuwangserverspringboot.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author xinyuwang
 */
public interface TopicRepository extends CrudRepository<Topic,Integer> {

    /**
     * @param lessonId
     * @return list of topic
     */
    @Query(value = "select * from Topics where Topics.lesson_id=:lessonId", nativeQuery = true)
    public List<Topic> findTopicsForLesson(@Param("lessonId") String lessonId);
}
