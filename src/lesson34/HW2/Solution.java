package lesson34.HW2;
/*Напишите метод transferFileContent, который будет переносить все содержимое файла
fileFrom.txt в новый файл fileTo.txt.
Контент в начальном файле при этом должен быть удален,
но файл остается. В файле назначения, текст должен добавляться к уже существующему
с новой строки, если он есть. Если какого-то из файлов не существует или возникла
ошибка работы по стримами, выбрасывайте соответствующую ошибку, описание которой
должно содержать имя (путь) проблемного файла. Решение должно содержаться в классе Solution.
Тестирование - в классе Demo
        Сигнатура метода:
        transferFileContent(String fileFromPath, String fileToPath)
*/
import java.io.*;

public class Solution {

    public static void transferFileContent(String fileFromPath, String fileToPath) {
        try {
            validate(fileFromPath, fileToPath);
            writeToFile(fileToPath, readFromFile(fileFromPath));
            eriseFile(fileFromPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void eriseFile(String path) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            bufferedWriter.append("");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private static StringBuffer readFromFile(String path) throws IOException {
        StringBuffer res = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line=br.readLine())!=null){
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length()-1,res.length(),"");
        }catch (FileNotFoundException e){
            System.out.println("Reading from file" + path + "failed");
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

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }
        if (!fileTo.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permission to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " does not have permission to be written");
        }
    }
}
