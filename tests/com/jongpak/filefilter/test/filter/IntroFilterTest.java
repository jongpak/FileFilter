package com.jongpak.filefilter.test.filter;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.jongpak.filefilter.filters.IntroFilter;

public class IntroFilterTest {

    @Test
    public void test() {
        File file = new File("test.txt");

        IntroFilter filter = new IntroFilter();

        assertEquals(1, filter.filter(file).size());
        assertEquals(file, filter.filter(file).get(0));
    }

}
