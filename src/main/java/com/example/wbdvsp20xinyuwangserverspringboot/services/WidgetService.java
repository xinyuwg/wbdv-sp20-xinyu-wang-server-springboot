package com.example.wbdvsp20xinyuwangserverspringboot.services;

import com.example.wbdvsp20xinyuwangserverspringboot.models.Topic;
import com.example.wbdvsp20xinyuwangserverspringboot.models.Widget;
import com.example.wbdvsp20xinyuwangserverspringboot.repositories.TopicRepository;
import com.example.wbdvsp20xinyuwangserverspringboot.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author xinyuwang
 */
@Service
public class WidgetService {
    final
    WidgetRepository widgetRepository;

    final
    TopicRepository topicRepository;

    public WidgetService(TopicRepository topicRepository, WidgetRepository widgetRepository) {
        this.topicRepository = topicRepository;
        this.widgetRepository = widgetRepository;
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) this.widgetRepository.findAll();
    }

    public List<Widget> findWidgetsForTopic(Integer tid) {
        Optional<Topic> topicOption = topicRepository.findById(tid);
        if (topicOption.isPresent()) {
            return topicOption.get().getWidgets();
        } else {
            return new ArrayList<>();
        }
    }

    public Widget createWidget(Integer topicId, Widget newWidget) {
        Topic topic = topicRepository.findById(topicId).get();
        newWidget.setTopic(topic);
        widgetRepository.save(newWidget);
        return newWidget;
    }

    public int updateWidget(Integer widgetId, Widget newWidget) {

        Optional<Widget> oldWidgetOptional = widgetRepository.findById(widgetId);
        if (oldWidgetOptional.isPresent()) {
            newWidget.setId(widgetId);
            newWidget.setTopic(oldWidgetOptional.get().getTopic());
            try {
                widgetRepository.save(newWidget);
                return 1;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;


    }

    public int deleteWidget(Integer widgetId) {
        try {
            widgetRepository.deleteById(widgetId);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public Widget findWidgetById(Integer widgetId) {
        return widgetRepository.findById(widgetId).orElseGet(Widget::new);
    }

}
