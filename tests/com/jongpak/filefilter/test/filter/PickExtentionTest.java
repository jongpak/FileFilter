package com.jongpak.filefilter.test.filter;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.jongpak.filefilter.Filter;
import com.jongpak.filefilter.filters.SelectExtention;

public class PickExtentionTest {
    @Test
    public void test() throws Exception {
        Filter filter = new SelectExtention();
        filter.option("extention", "txt");

        assertEquals(1, filter.filter(new File("test.txt")).size());
        assertEquals(null, filter.filter(new File("test.doc")));
        assertEquals(null, filter.filter(new File("test")));
        assertEquals(null, filter.filter(new File("test/")));
    }
}
