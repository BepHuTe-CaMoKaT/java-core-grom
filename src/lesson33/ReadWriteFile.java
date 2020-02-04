/*
Напишите метод readFile, который по заданному пути файла будет считывать все его
содержимое и выводить в консоль.
Второй метод writeFile, должен записывать заданный стринг в файл,
не перезатирая уже находящееся в нем содержимое.
Методы должны находиться в классе Solution
Сигнатрура методов:
readFile(String path)
writeFile(String path, String content)
В Demo классе протестируйте свои решения
*/



package lesson33;

import org.apache.commons.io.IOUtils;
import java.io.*;

public class ReadWriteFile {
    public static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }


    public static void writeFile(String path, String content) {
        FileWriter writer = null;
        BufferedWriter br = null;
        try {
            writer = new FileWriter(path,true);//append дописывает к содержимому файла
            br = new BufferedWriter(writer);
            br.append("\n"); //запись этого с новой строки
            br.append(content);
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(writer);
        }
    }
}