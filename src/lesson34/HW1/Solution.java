/*Напишите метод copyFileContent, который будет копировать все содержимое файла fileFrom.txt
 и записывать это в новый файл fileTo.txt. Если какого-то из файлов не существует или возникла
 ошибка работы по стримами, выбрасывайте соответствующую ошибку, описание которой должно содержать
 имя проблемного файла. Решение должно содержаться в классе Solution. Тестирование - в классе Demo
        Сигнатура метода:
        copyFileContent(String fileFromPath, String fileToPath)
P.S. В уроке часть ошибок мы писали в консоль, в условии же нужно работать
 с исключениями, поэтому учитывайте это в своем решении
*/
package lesson34.HW1;

import java.io.*;

public class Solution {
    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        //проверить что файлы есть
        //проверить права
        //считать с файла
        //записать в файл
        validate(fileFromPath, fileToPath);
        readFromFile(fileFromPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));

    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.out.println("Error");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists()) throw new Exception("Error");
        if (!fileTo.exists()) throw new Exception("Error");
        if (!fileFrom.canRead()) throw new Exception("Error");
        if (!fileTo.canWrite()) throw new Exception("Error;");

    }
}
