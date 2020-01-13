package lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WorkInFile {
    public static void main(String[] args) throws FileNotFoundException {
        aaa();

    }

    public static void aaa() {
        try(FileInputStream fin=new FileInputStream("C://Games//encoded.txt"))
        {
            System.out.printf("File size: %d bytes \n", fin.available());
            char[] chars=new char[144];
            int index=0;
            int i=-1;
            while((i=fin.read())!=-1){
                for (char ch:chars){
                    if (ch==0){
                        chars[index]=(char)i;
                    }
                    index++;
                }
                System.out.print(chars);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
