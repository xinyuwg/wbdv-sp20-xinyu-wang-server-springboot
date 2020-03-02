package com.example.wbdvsp20xinyuwangserverspringboot.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author xinyuwang
 */
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String lessonId;

    @OneToMany(mappedBy = "topic")
    List<Widget> widgets;

    public Topic() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLessonId() {
        return lessonId;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }


}
