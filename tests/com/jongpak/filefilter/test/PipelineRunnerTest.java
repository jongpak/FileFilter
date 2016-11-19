package com.jongpak.filefilter.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.jongpak.filefilter.Pipeline;
import com.jongpak.filefilter.PipelineRunner;
import com.jongpak.filefilter.test.mock.DupFilter;
import com.jongpak.filefilter.test.mock.MatchFilter;

public class PipelineRunnerTest {

    @Test
    public void test() throws Exception {
        List<File> filtered = new LinkedList<>();

        Pipeline pipeline = new Pipeline();
        PipelineRunner runner = new PipelineRunner(pipeline);

        pipeline.put(new MatchFilter().option("match", "test1.txt"));
        pipeline.put(new DupFilter().option("dest", filtered));

        runner.run(new File(this.getClass().getResource("sample_files/test1.txt").getPath()));
        assertEquals(1, filtered.size());

        filtered.clear();
        runner.run(new File(this.getClass().getResource("sample_files/test2.txt").getPath()));
        assertEquals(0, filtered.size());
    }

}
