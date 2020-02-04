/*
Напишите метод, который будет считывать 10 чисел с клавиатуры в одной строке и считать их сумму.
Числа должны быть разделены между собой пробелом, а так же каждое число не может привышать 100
Если в вводе допущена ошибка, выведите в консоль “Your numbers are wrong.
You have n (подставить ко-во оставшихся попыток) attempts to try again” и предложить
пользователю заново ввести информацию. Если после трех попыток формат данных не верный
выводите “Your numbers are wrong. Number of attempts exceeded”
Сигнатура метода:
readNumbers()
*/
package lesson32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.io.IOUtils;

public class Solution {

    public static void readNumbers() throws IOException {

        System.out.println("Please enter numbers");
        int sum = 0;
        int p = 3;
        while (p != 0) {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);
            String[] stringsTemp = br.readLine().split(" ");
            sum = 0;
            System.out.println("!!!!!!!!!!!!!!!!отладка!!!!!!!!!!!!!!!");
            for (String temp : stringsTemp) {

                if (isNumeric(temp) && Integer.parseInt(temp) <= 100) {
                    sum += Integer.parseInt(temp);
                }
                else {
                    p -= 1;
                    System.out.println("Your numbers are wrong. You have  " + p + "  attempts to try again");
                    sum = 0;
                }

            }
            if (p == 0) {
                System.out.println("Your numbers are wrong. Number of attempts exceeded");
                break;
            }
            if (sum != 0) {
                System.out.println("sum=" + sum);
                break;
            }

        }

    }
    private static boolean isNumeric(String strNum) {
        try {
            Integer i = Integer.parseInt (strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
