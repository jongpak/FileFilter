package com.jongpak.filefilter;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class PipelineRunner {
    private Pipeline pipeline;

    public PipelineRunner(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    public void run(File entryFile) throws Exception {
        List<File> prevFiles = new LinkedList<>();
        prevFiles.add(entryFile);

        for (Filter filter : pipeline) {
            List<File> filteredFiles = new LinkedList<>();

            for (File file : prevFiles) {
                List<File> localFilteredFiles = filter.filter(file);

                if (localFilteredFiles != null) {
                    filteredFiles.addAll(filter.filter(file));
                }
            }

            prevFiles = filteredFiles;
        }
    }
}
