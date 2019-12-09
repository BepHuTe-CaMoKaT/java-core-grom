package lesson18.CW.ex2;

import lesson18.CW.ex2.FileStorage;
import lesson18.CW.ex2.Storage;

public class Task {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        String[] fileNames = {"test1","test2"};
        fileStorage.setFiles(fileNames);
        printer(fileStorage);
    }
    public static void printer(Storage storage){
        String[] names = storage.getFiles();
        try{
        System.out.println("5th element is"+names[4]);
        } catch (Exception e){
            System.err.println("5th element can't be found");
        }
    }
}
