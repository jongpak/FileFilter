package com.jongpak.filefilter.filters;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import com.jongpak.filefilter.Filter;

public class CopyFiles extends Filter {
    private String dest = "";

    public CopyFiles() {
        addOptionHandler("destination", dest -> this.dest = (String) dest);
    }

    @Override
    public List<File> filter(File file) throws Exception {
        File destFile = new File(dest + File.separator + file.getName());
        Files.copy(file.toPath(), destFile.toPath());

        return pass(destFile);
    }
}
