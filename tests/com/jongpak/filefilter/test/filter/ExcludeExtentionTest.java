package com.jongpak.filefilter.test.filter;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.jongpak.filefilter.Filter;
import com.jongpak.filefilter.filters.ExcludeExtention;

public class ExcludeExtentionTest {
    @Test
    public void test() throws Exception {
        Filter filter = new ExcludeExtention();
        filter.option("extention", "txt");

        assertEquals(null, filter.filter(new File("test.txt")));
        assertEquals(1, filter.filter(new File("test.doc")).size());
        assertEquals(1, filter.filter(new File("test")).size());
        assertEquals(1, filter.filter(new File("test/")).size());
    }
}
