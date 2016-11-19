package com.jongpak.filefilter.test.mock;

import java.io.File;
import java.util.List;

import com.jongpak.filefilter.Filter;

public class OptionDummyFilter extends Filter {
    private String matchString;

    public OptionDummyFilter() {
        addOptionHandler("match", string -> matchString = (String) string);
    }

    @Override
    public List<File> filter(File file) throws Exception {
        return file.getName().equals(matchString) ? pass(file) : null;
    }
}
