package com.jongpak.filefilter.filters;

import java.io.File;
import java.util.List;

public class Unixls extends PrintList {
    @Override
    public List<File> filter(File file) {
        out.print(file.isDirectory() ? "d" : "-");

        out.print(file.canRead() ? "r" : "-");
        out.print(file.canWrite() ? "w" : "-");
        out.print(file.canExecute() ? "x" : "-");

        out.print(String.format("  %10d", file.length()));

        out.print("  " + file.getName() + (file.isDirectory() ? "/" : ""));

        out.print(System.lineSeparator());

        return pass(file);
    }

}
