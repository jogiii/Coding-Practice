package designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    private String name;

    List<FileSystem> fileSystemList;

    public Directory(String name) {
        this.name = name;
        this.fileSystemList = new ArrayList<>();
    }

    void add(FileSystem fs){
        fileSystemList.add(fs);
    }

    void remove(FileSystem fs){
        fileSystemList.remove(fs);
    }
    @Override
    public void printFileName() {
        System.out.println("Searching directory: "+name);

        for(FileSystem fsObj : fileSystemList)      {
            fsObj.      printFileName();
        }



    }
}
