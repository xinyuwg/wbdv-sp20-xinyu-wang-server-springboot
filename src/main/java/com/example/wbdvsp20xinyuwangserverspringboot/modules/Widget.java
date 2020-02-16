package com.example.wbdvsp20xinyuwangserverspringboot.modules;

public class Widget {
    private String name;
    private String id;
    private String tid;
    private String type;
    private Integer order;
    private String text;
    private String url;
    private String size;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;

    public String getName() {
        return name;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTid() {
        return tid;
    }

    public String getId() {
        return id;
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

    public String getUrl() {
        return url;
    }

    public String getSize() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSize(String size) {
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

    public Widget(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Widget(String name, String id, String tid) {
        this.name = name;
        this.id = id;
        this.tid = tid;
    }

    public Widget() {
    }
}