package com.jongpak.filefilter.filters;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.jongpak.filefilter.Filter;

public class ChildFiles extends Filter {
    private boolean isRecursive = false;

    public ChildFiles() {
        addOptionHandler("recursive", flag -> isRecursive = (boolean) flag);
    }

    @Override
    public List<File> filter(File file) throws Exception {
        LinkedList<File> files = new LinkedList<>();

        if (isRecursive == true) {
            Files.walkFileTree(Paths.get(file.getPath()), new SimpleChildFileVisitor(files));
        } else {
            files.addAll(Arrays.asList(file.listFiles()));
        }

        return files;
    }

    protected class SimpleChildFileVisitor extends SimpleFileVisitor<Path> {
        private List<File> files;

        public SimpleChildFileVisitor(List<File> files) {
            this.files = files;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
            files.add(new File(path.toUri()));
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.SKIP_SUBTREE;
        }
    }
}
