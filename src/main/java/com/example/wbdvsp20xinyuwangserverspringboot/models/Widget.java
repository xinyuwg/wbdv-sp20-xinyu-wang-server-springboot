package com.example.wbdvsp20xinyuwangserverspringboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author xinyuwang
 */
@Entity
@Table(name = "widgets")
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private Integer order;
    private String text;
    private String src;
    private Integer size;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;

    @ManyToOne
    @JsonIgnore
    private Topic topic;

    public Widget() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getOrder() {
        return order;
    }

    public String getText() {
        return text;
    }

    public String getSrc() {
        return src;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public String getStyle() {
        return style;
    }

    public String getValue() {
        return value;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
