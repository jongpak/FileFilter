package com.jongpak.filefilter.filters;

import java.io.File;
import java.io.PrintStream;
import java.util.List;

import com.jongpak.filefilter.Filter;

public class PrintList extends Filter {
    protected PrintStream out = System.out;

    public PrintList() {
        addOptionHandler("out", out -> this.out = (PrintStream) out);
    }

    @Override
    public List<File> filter(File file) {
        out.println(file.getAbsolutePath() + (file.isDirectory() ? File.separator : ""));

        return pass(file);
    }

}
