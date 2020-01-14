package lesson3;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Decrypting {

    public static void main(String[] args) {

        String text;
        String text2;

        try {
            Path encodedPath = Paths.get("C://Games//encoded.txt");
            File encodedFile = new File(String.valueOf(encodedPath));

            Path codedPath = Paths.get("C://Games//code.txt");
            File codedFile = new File(String.valueOf(codedPath));

            StringBuilder codedBuilder = new StringBuilder();
            StringBuilder encodedBuilder = new StringBuilder();

            try (
                    FileInputStream encoded = new FileInputStream(encodedFile.getAbsolutePath());
                    FileInputStream coded = new FileInputStream(codedFile.getAbsolutePath())
            ) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(coded))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null){
                        codedBuilder.append(line);
                    }
                    text = codedBuilder.toString();
                }
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(encoded))){
                    String line;
                    while ((line = bufferedReader.readLine()) != null){
                        encodedBuilder.append(line);
                    }
                    text2 = encodedBuilder.toString();
                }
                char[] chars = text.toCharArray();
                char[] chars2 = text2.toCharArray();

                char[] res = new char[text.length()];
                for (int i = 0; i < res.length; i++) {
                    res[i]=(char)(chars2[i]-chars[i]);
                }
                System.out.println(res);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

