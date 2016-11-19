package com.jongpak.filefilter.test.mock;

import java.io.File;
import java.util.List;

import com.jongpak.filefilter.Filter;

public class DupFilter extends Filter {
    private List<File> dest;

    public DupFilter() {
        addOptionHandler("dest", dest -> this.dest = (List<File>) dest);
    }

    @Override
    public List<File> filter(File file) throws Exception {
        dest.add(file);
        return pass(file);
    }
}
