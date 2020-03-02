package com.example.wbdvsp20xinyuwangserverspringboot.controllers;


import com.example.wbdvsp20xinyuwangserverspringboot.models.Widget;
import com.example.wbdvsp20xinyuwangserverspringboot.repositories.WidgetRepository;
import com.example.wbdvsp20xinyuwangserverspringboot.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinyuwang
 */
@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    final
    WidgetService widgetService;

    public WidgetController(WidgetService widgetService) {
        this.widgetService = widgetService;
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidget() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/api/topic/{tid}/widgets")
    public List<Widget> findWidgetForTopic(@PathVariable("tid") Integer tid) {
        return widgetService.findWidgetsForTopic(tid);
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Integer wid) {
        return widgetService.findWidgetById(wid);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(@PathVariable("tid") Integer tid, @RequestBody Widget newWidget) {
        return widgetService.createWidget(tid, newWidget);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") Integer wid, @RequestBody Widget newWidget) {
        return widgetService.updateWidget(wid, newWidget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") Integer wid) {
        return widgetService.deleteWidget(wid);
    }

}
