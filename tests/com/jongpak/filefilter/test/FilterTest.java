package com.jongpak.filefilter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import com.jongpak.filefilter.Filter;
import com.jongpak.filefilter.test.mock.FilterOptionMock;
import com.jongpak.filefilter.test.mock.FilterPassMock;

public class FilterTest {

    @Test
    public void testPassMethod() throws Exception {
        Filter filter = new FilterPassMock();
        File file = new File("pass.txt");

        assertEquals(1, filter.filter(file).size());
        assertEquals(file, filter.filter(file).get(0));
    }

    @Test
    public void testOptionMethod() throws Exception {
        Filter filter = new FilterOptionMock();
        File file = new File("pass.txt");

        filter.option("match", "pass.txt");
        assertEquals(1, filter.filter(file).size());
        assertEquals(file, filter.filter(file).get(0));

        filter.option("match", "test.txt");
        assertEquals(null, filter.filter(file));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOptionMethodWithIllegalOption() throws Exception {
        Filter filter = new FilterOptionMock();
        filter.option("noOptionKey", null);
    }

    @Test
    public void testGetOptionMethod() {
        Filter filter = new FilterOptionMock();
        assertEquals(1, filter.getOptions().size());
        assertTrue(((String) filter.getOptions().toArray()[0]).equals("match"));
    }
}
