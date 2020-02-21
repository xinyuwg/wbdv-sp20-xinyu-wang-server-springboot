package com.example.wbdvsp20xinyuwangserverspringboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinyuwang
 */

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    WidgetService service = new WidgetService();

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") String widgetId) throws WidgetService.FindMoreThanOneWidgetWithSameIdException {
        return service.findWidgetById(widgetId);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") String tid) {
        return service.findWidgetsForTopic(tid);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(@PathVariable("tid") String tid, @RequestBody Widget newWidget) {
        return service.createWidget(tid, newWidget);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") String wid, @RequestBody Widget widget) {
        return service.updateWidget(wid, widget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") String wid) {
        return service.deleteWidget(wid);
    }




}
