package org.example;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        Folder smallFolder = new FileCabinet.FolderImpl("Documents", "SMALL");
        Folder mediumFolder = new FileCabinet.FolderImpl("Pictures", "MEDIUM");
        Folder largeFolder = new FileCabinet.FolderImpl("Videos", "LARGE");

        Folder compositeFolder = new FileCabinet.MultiFolderImpl("multifolder", "LARGE", List.of(smallFolder, mediumFolder));

        FileCabinet fileCabinet = new FileCabinet(List.of(smallFolder, mediumFolder, largeFolder, compositeFolder));

        System.out.println(fileCabinet.count());
    }

}