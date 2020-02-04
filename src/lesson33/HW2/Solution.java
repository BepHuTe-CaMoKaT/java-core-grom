/*Напишите метод writeToFileFromConsole, который будет записывать все содержимое введенное
пользователем с консоли в файл по заданному пути, не перезаписывая содержимое файла.
После приветствия "Enter file content to write in the file:", пользователь получает возможность ввести
произвольное ко-во текста в консоли, который должен будет записан в файл.
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

package lesson33.HW2;
import org.apache.commons.io.IOUtils;
import java.io.*;

public class Solution {


    public static void readFileByConsolePath() {
        System.out.println("Please, enter file path to read:");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String stringsTemp = null;
        try {
            stringsTemp = br.readLine();

        } catch (IOException e) {
            System.err.println("File does not exist");

        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
        readFile(stringsTemp);

    }

    public static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);

        } catch (FileNotFoundException e) {
            System.err.println("Can`t read file by path "+path);
            return;
        }
        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("File with path " + path + " not found");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
}