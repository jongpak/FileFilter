package com.jongpak.filefilter.filters;

import java.io.File;
import java.util.List;

import com.jongpak.filefilter.Filter;

public class IntroFilter extends Filter {
    @Override
    public List<File> filter(File file) {
        return pass(file);
    }

}
