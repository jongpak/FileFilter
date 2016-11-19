package com.jongpak.filefilter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

import com.jongpak.filefilter.Filter;
import com.jongpak.filefilter.Pipeline;
import com.jongpak.filefilter.filters.IntroFilter;
import com.jongpak.filefilter.test.mock.PassFilter;

public class PipelineTest {

    @Test
    public void test() {
        Pipeline pipeline = new Pipeline();
        Iterator<Filter> iter = pipeline.iterator();

        assertEquals(IntroFilter.class, iter.next().getClass());
        assertFalse(iter.hasNext());
    }

    @Test
    public void testPutMethod() {
        Pipeline pipeline = new Pipeline();
        pipeline.put(new PassFilter());

        Iterator<Filter> iter = pipeline.iterator();

        assertEquals(IntroFilter.class, iter.next().getClass());
        assertEquals(PassFilter.class, iter.next().getClass());
        assertFalse(iter.hasNext());
    }

}
