package com.jongpak.filefilter.test.mock;

import java.io.File;
import java.util.List;

import com.jongpak.filefilter.Filter;

public class PassFilter extends Filter {
    @Override
    public List<File> filter(File file) throws Exception {
        return pass(file);
    }
}
