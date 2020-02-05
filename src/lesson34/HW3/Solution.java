package lesson34.HW3;

import java.io.*;

/*
Напишите метод transferSentences, который будет переносить все предложения в файле fileFrom.txt,
содержащее входящее слово, в новый файл fileTo.txt.
Предоложением считае текст находящийся между двумя точками (.) длинной больше 10.
Перенесенное предложение при этом должно быть удалено из входящего файла.
Если какого-то из файлов не существует или возникла ошибка работы по стримами,
выбрасывайте соответствующую ошибку, описание которой должно содержать имя (путь) проблемного файла
Решение должно содержаться в классе Solution. Тестирование - в классе Demo
Сигнатура метода:
transferSentences(String fileFromPath, String fileToPath, String word)
 */
public class Solution {
    public static void transferSentences(String fileFromPath, String fileToPath, String word) {
        try {
            validate(fileFromPath, fileToPath);
            writeToFile(fileToPath, Sentences(readFromFile(fileFromPath), word, true));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static StringBuffer Sentences(StringBuffer content, String word, boolean addOrRemove) {
        StringBuffer add = new StringBuffer();
        StringBuffer remove = new StringBuffer();

        String[] temp = content.toString().split("[.?!]\\s");//разбиваем предложения
        for (int i = 0; i < temp.length; i++) {
            temp[i]=temp[i]+"."+" ";
            String[] temp2 = temp[i].split(" ");
            if (temp2.length>10-1&&temp[i].contains(" "+word+" ")){
                add.append(temp[i]);
                temp[i]="";
            }
            remove.append(temp[i]);
        }
        if (addOrRemove) return add;
        return remove;
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
        }
        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can not write to file " + e.getMessage());
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) throw new FileNotFoundException("File " + fileFrom + " does not exist");
        if (!fileTo.exists()) throw new FileNotFoundException("File " + fileTo + " does not exist");
        if (!fileFrom.canRead()) throw new Exception("File " + fileFrom + " does not have permission to be read");
        if (!fileTo.canWrite()) throw new Exception("File " + fileTo + " does not have permission to be written");
        if (!fileFrom.canWrite()) throw new Exception("File " + fileFrom + " does not have permission to be written");
    }
}
