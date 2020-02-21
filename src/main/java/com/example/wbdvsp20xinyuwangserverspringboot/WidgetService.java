package com.example.wbdvsp20xinyuwangserverspringboot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author xinyuwang
 */

public class WidgetService {
    List<Widget> widgetList = new ArrayList<>();
    {
        widgetList.add(new Widget("ds", "sds"));
    }
    static class FindMoreThanOneWidgetWithSameIdException extends Exception {
    }

    public List<Widget> findAllWidgets() {
        return widgetList;
    }

    public Widget findWidgetById(String widgetId) throws NoSuchElementException, FindMoreThanOneWidgetWithSameIdException {
        List<Widget> findWidgetResList = widgetList
                .stream()
                .filter(widget -> widgetId.equals(widget.getId()))
                .collect(Collectors.toList());
        if (findWidgetResList.size() == 0) {
            return null;
        } else if (findWidgetResList.size() == 1) {
            return findWidgetResList.get(0);
        } else {
            throw new FindMoreThanOneWidgetWithSameIdException();
        }
    }

    public Widget createWidget(String tid, Widget widget) {
        widget.setTid(tid);
        widgetList.add(widget);
        return widget;
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        return widgetList
                .stream()
                .filter(widget -> widget.getTid().equals(tid))
                .collect(Collectors.toList());
    }

    public int updateWidget(String wid, Widget newWidget) {
        try {
            this.widgetList = this.widgetList.stream().map((Widget widget) -> {
                if (widget.getId().equals(wid)) {
//                    System.out.println(wid);
                    return newWidget;
                } else {
                    return widget;
                }
            }).collect(Collectors.toList());
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    public int deleteWidget(String wid) {
        try {
            System.out.println(wid);
            AtomicInteger index = new AtomicInteger(0);
            this.widgetList = this.widgetList.stream()
                    .filter(widget -> !widget.getId().equals(wid))
                    .sorted(Comparator.comparingInt(Widget::getOrder))
                    .peek(widget -> widget.setOrder(index.getAndIncrement()))
                    .collect(Collectors.toList());
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }


}
