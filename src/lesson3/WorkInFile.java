package lesson3;
//doesn't work correctly
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class WorkInFile {
    public static void main(String[] args){
        try {
            FileInputStream encoded = new FileInputStream("C://Games//encoded.txt");
            FileInputStream coded = new FileInputStream("C://Games//code.txt");
            String text = new String(Files.readAllBytes(Paths.get("C://Games//encoded.txt")));
            System.out.println("Encoded.txt = " + text);

            String text2 = new String(Files.readAllBytes(Paths.get("C://Games//code.txt")));
            System.out.println("code.txt = " + text2);
            char[] chars=text.toCharArray();
            char[] chars2=text2.toCharArray();
            int index=0;
            int index2=0;
            int i=-1;
            while((i=encoded.read())!=-1){
               chars[index]=((char)i);
               index++;
            }
            int j=-1;
            while((j=coded.read())!=-1){
                chars2[index2]=((char)j);
                index2++;
            }
            //System.out.println(Arrays.toString(chars));
            //System.out.println(Arrays.toString(chars2));
           int index3 = 0;
            char[] res = new char[chars.length];
            for (int a=0;a<=chars.length;a++){

                res[a] = (char) (chars2[a] - chars[a]);


            }
//            String result = Arrays.toString(res);
            System.out.println(res);
            encoded.close();
            coded.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
