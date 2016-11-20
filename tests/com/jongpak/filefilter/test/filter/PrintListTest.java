package com.jongpak.filefilter.test.filter;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.jongpak.filefilter.Filter;
import com.jongpak.filefilter.filters.PrintList;

public class PrintListTest {
    @Test
    public void testFile() throws Exception {
        OutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);

        Filter filter = new PrintList().option("out", out);
        File file = new File(this.getClass().getResource("../sample_files/test1.txt").getPath());

        filter.filter(file);
        assertEquals(file.getPath() + System.lineSeparator(), stream.toString());
    }

    @Test
    public void testDirectory() throws Exception {
        OutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);

        Filter filter = new PrintList().option("out", out);
        File file = new File(this.getClass().getResource("../sample_files").getPath());

        filter.filter(file);
        assertEquals(file.getPath() + File.separator + System.lineSeparator(), stream.toString());
    }
}
