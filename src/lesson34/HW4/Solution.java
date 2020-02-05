package lesson34.HW4;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
Напишите метод copyFileContent, который будет копиторать все содержимое файла fileFrom.txt
и записывать это в новый файл fileTo.txt.
Используйте стандартные методы с JDK класса File.
Во втором методе используйте стандартные методы библиотеки Apache IO
Решение должно содержаться в классе Solution. Тестирование - в классе Demo
Сигнатура методов:
copyFileContent(String fileFromPath, String fileToPath)
copyFileContentApacheIO(String fileFromPath, String fileToPath)
 */
public class Solution {
    public static void copyFileContent(String fileFromPath, String fileToPath) {
        try {
            validate(fileFromPath, fileToPath);
            writeToFile(fileToPath, readFromFile(fileFromPath));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath){
        try {
            validate(fileFromPath, fileToPath);
            writeToFileApacheIO(fileToPath, readFromFileApacheIO(fileFromPath));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length()-1,res.length(),"");
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");

        }
        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println();
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) throw new FileNotFoundException("File " + fileFrom + " does not exist");
        if (!fileTo.exists()) throw new FileNotFoundException("File " + fileTo + " does not exist");
        if (!fileTo.canRead()) throw new Exception("File " + fileFrom + " does not have permission to be read");
        if (!fileTo.canWrite()) throw new Exception("File " + fileTo + " does not have permission to be written");
    }

    private static String readFromFileApacheIO(String path){
        String res = null;
        try{
            res= FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error");
        }
        return res;
    }
    private static void writeToFileApacheIO(String path, String contentToWrite){
        try {
            FileUtils.write(new File(path),contentToWrite,StandardCharsets.UTF_8,true);
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
}
