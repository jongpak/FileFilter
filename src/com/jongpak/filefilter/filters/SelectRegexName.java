package com.jongpak.filefilter.filters;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import com.jongpak.filefilter.Filter;

public class SelectRegexName extends Filter {
    private String regex;

    public SelectRegexName() {
        addOptionHandler("regex", regex -> this.regex = (String) regex);
    }

    @Override
    public List<File> filter(File file) {
        return Pattern.matches(regex, file.getName()) ? pass(file) : null;
    }
}
