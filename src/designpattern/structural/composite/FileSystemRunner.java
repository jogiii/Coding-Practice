package designpattern.structural.composite;

import java.io.File;

public class FileSystemRunner {

    public static void main(String[] args) {

        String directoryPath = "E:\\Workspace\\root";
        Directory root = readDirectory(directoryPath);
        root.printFileName();


    }

    public static Directory readDirectory(String directoryPath){
        Directory directory = new Directory(directoryPath);

        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        for(File file : files){
            if(file.isFile()) {
                directory.add(new FileLeaf(file.getName()));
            }else if(file.isDirectory()){
                directory.add(readDirectory(file.getAbsolutePath()));
            }
        }
        return directory;

    }
}
