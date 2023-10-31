package designpattern.structural.composite;

public class FileLeaf implements FileSystem{
    private String name;

    public FileLeaf(String name){
        this.name = name;
    }
    @Override
    public void printFileName() {
        System.out.println("File Name is "+name);
    }
}
