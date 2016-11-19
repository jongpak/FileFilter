package com.jongpak.filefilter.test.filter;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.jongpak.filefilter.filters.ChildFiles;

public class ChildFilesTest {
    private File sample_files = new File(this.getClass().getResource("../sample_files/").getPath());

    @Test
    public void test() throws Exception {
        assertEquals(7, new ChildFiles().filter(sample_files).size());
    }

    @Test
    public void testRecursive() throws Exception {
        assertEquals(11, new ChildFiles().option("recursive", true).filter(sample_files).size());
    }

}
