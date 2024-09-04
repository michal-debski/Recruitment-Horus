package org.example;

import java.util.List;
import java.util.Optional;

public class FileCabinet implements Cabinet {
    private final List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return folders.stream()
                .filter(folder -> folder.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return folders.stream()
                .filter(folder -> folder.getSize().equals(size))
                .toList();
    }

    @Override
    public int count() {
        return countFolders(folders);
    }

    private int countFolders(List<Folder> folders) {
        int numberOfFolders = 0;
        for (Folder folder : folders) {
            numberOfFolders++;
            if (folder instanceof MultiFolder) {
                numberOfFolders += countFolders(((MultiFolder) folder).getFolders());
            }
        }
        return numberOfFolders;
    }

    public static class FolderImpl implements Folder {
        private final String name;

        private final String size;

        public FolderImpl(String name, String size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getSize() {
            return size;
        }

        @Override
        public String toString() {
            return "Folder with " +
                   "name: '" + name + '\'' +
                   "and size: '" + size;
        }
    }

    public static class MultiFolderImpl implements MultiFolder {

        private final List<Folder> subFolders;


        public MultiFolderImpl(String name, String size, List<Folder> subFolders) {
            this.subFolders = subFolders;
        }

        @Override
        public List<Folder> getFolders() {
            return subFolders;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getSize() {
            return null;
        }
    }
}
