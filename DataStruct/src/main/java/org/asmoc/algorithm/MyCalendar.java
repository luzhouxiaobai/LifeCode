package org.asmoc.algorithm;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {

    public TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        Map.Entry<Integer, Integer> min = map.floorEntry(start);
        if (min != null && min.getValue()>start) return false;

        Map.Entry<Integer, Integer> max = map.ceilingEntry(start);
        if (max != null && max.getKey()<end) return false;

        map.put(start, end);
        return true;

    }
}
