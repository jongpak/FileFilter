package com.jongpak.filefilter.test.filter;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.jongpak.filefilter.Filter;
import com.jongpak.filefilter.filters.PickRegexName;

public class PickRegexNameTest {
    @Test
    public void test() throws Exception {
        Filter filter = new PickRegexName();
        filter.option("regex", "test[0-9]\\.txt");

        assertEquals(1, filter.filter(new File("test1.txt")).size());
        assertEquals(null, filter.filter(new File("test2.doc")));
        assertEquals(null, filter.filter(new File("test")));
        assertEquals(null, filter.filter(new File("test/")));
    }
}
