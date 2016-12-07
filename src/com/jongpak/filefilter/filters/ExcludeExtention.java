package com.jongpak.filefilter.filters;

import java.io.File;
import java.util.List;

public class ExcludeExtention extends SelectExtention {
    @Override
    public List<File> filter(File file) {
        return extentions.contains(getExtention(file)) ? null : pass(file);
    }
}
