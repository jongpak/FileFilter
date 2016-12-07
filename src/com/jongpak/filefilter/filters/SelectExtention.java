package com.jongpak.filefilter.filters;

import java.io.File;
import java.util.HashSet;
import java.util.List;

import com.jongpak.filefilter.Filter;

public class SelectExtention extends Filter {
    protected HashSet<String> extentions = new HashSet<>();

    public SelectExtention() {
        addOptionHandler("extention", extention -> extentions.add(((String) extention).toLowerCase()));
    }

    @Override
    public List<File> filter(File file) {
        return extentions.contains(getExtention(file)) || file.isDirectory() ? pass(file) : null;
    }

    protected String getExtention(File file) {
        String fileName = file.getName();
        int pos = fileName.lastIndexOf(".");

        return pos != -1 ? fileName.substring(pos + 1) : "";
    }
}
