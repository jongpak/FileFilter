package com.jongpak.filefilter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.jongpak.filefilter.filters.IntroFilter;

public class Pipeline implements Iterable<Filter> {
    private List<Filter> filters = new LinkedList<>();

    public Pipeline() {
        filters.add(new IntroFilter());
    }

    public void put(Filter filter) {
        filters.add(filter);
    }

    @Override
    public Iterator<Filter> iterator() {
        return filters.iterator();
    }
}
