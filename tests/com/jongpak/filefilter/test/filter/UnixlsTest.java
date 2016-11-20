package com.jongpak.filefilter.test.filter;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.jongpak.filefilter.Filter;
import com.jongpak.filefilter.filters.Unixls;

public class UnixlsTest {
    @Test
    public void testFile() throws Exception {
        OutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);

        Filter filter = new Unixls();
        File file = new File(this.getClass().getResource("../sample_files/test1.txt").getPath());

        filter.option("out", out);
        filter.filter(file);

        assertEquals("-rwx           0  test1.txt" + System.lineSeparator(), stream.toString());
    }

    @Test
    public void testDirectory() throws Exception {
        OutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);

        Filter filter = new Unixls();
        File file = new File(this.getClass().getResource("../sample_files").getPath());

        filter.option("out", out);
        filter.filter(file);

        assertEquals("drwx        " + file.length() + "  sample_files/" + System.lineSeparator(), stream.toString());
    }
}
