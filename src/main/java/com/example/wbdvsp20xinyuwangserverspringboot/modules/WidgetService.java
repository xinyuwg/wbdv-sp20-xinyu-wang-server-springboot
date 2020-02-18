package com.example.wbdvsp20xinyuwangserverspringboot.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * @author xinyuwang
 */

public class WidgetService {
    List<Widget> widgetList = new ArrayList<>();

    {
        widgetList.add(new Widget("dsds", "123","321"));
        widgetList.add(new Widget("eqwe", "234","123"));
        widgetList.add(new Widget("vcvc", "456","321"));

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
            this.widgetList = this.widgetList.stream()
                    .filter(widget -> !widget.getId().equals(wid))
                    .collect(Collectors.toList());
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }


}
