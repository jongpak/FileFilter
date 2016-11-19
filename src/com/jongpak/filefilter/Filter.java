package com.jongpak.filefilter;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public abstract class Filter {
    private HashMap<String, Consumer<Object>> options = new HashMap<>();

    public abstract List<File> filter(File file) throws Exception;

    public List<File> pass(File file) {
        LinkedList<File> singleFile = new LinkedList<>();
        singleFile.add(file);

        return singleFile;
    }

    public Filter option(String key, Object value) {
        if (options.containsKey(key) == false) {
            throw new IllegalArgumentException("[" + key + "] is illegal key");
        }

        options.get(key).accept(value);

        return this;
    }

    protected void addOptionHandler(String key, Consumer<Object> handler) {
        options.put(key, handler);
    }

    public Set<String> getOptions() {
        return options.keySet();
    }
}
