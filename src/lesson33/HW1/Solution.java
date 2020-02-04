/*
Напишите метод writeToFileFromConsole, который будет записывать все содержимое введенное пользователем
с консоли в файл по заданному пути, не перезаписывая содержимое файла.
После приветствия "Enter file content to write in the file:", пользователь получает возможность
ввести произвольное ко-во текста в консоли, который должен будет записан в файл.
Ограничений на содержимое текста нет. После ввода в отдельной строки команды wr,
программа должна записать весь текст с консоли в заданный файл
Если запись по введенному пути невозможно, выводить ошибку в консоль
"Can't write to file with path -введенный путь-".
Если файла по заданному пути не существует выводить в консоль ошибку
"File with path -введенный путь- not found"
Сигнатрура метода:
writeToFileFromConsole(String path)
В Demo классе протестируйте свое решение
 */


package lesson33.HW1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {
    public static void writeToFileFromConsole(String path) {

        writeFile(path, readFromKeyboard());
    }


    private static String readFromKeyboard() {

        System.out.println("Enter file content to write in the file:");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        StringBuilder stringStore = new StringBuilder();

        try {
            String temp;

            while (( temp=br.readLine())!=null) {
                if (temp.equals("wr")) { break; }
                stringStore.append(temp);
                stringStore.append(System.lineSeparator());
            }

        }catch(IOException e){
            System.err.println("Reading from keyboard failed");

        } finally{
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
            return stringStore.toString();
        }

    }

    private static void writeFile(String path, String content) {
        FileWriter writer = null;
        BufferedWriter br = null;
        try {
            writer = new FileWriter(path, true);
            br = new BufferedWriter(writer);
            br.append('\n');
            br.append(content);
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(writer);
        }
    }


}