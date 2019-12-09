package lesson18;

import java.util.Arrays;

public class Definition {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers("rere 1111 ifi2 4123")));
    }
//Напишите метод который будет принимать текст на вход и возвращать массив int[] всех чисел которые в нем содержаться.
// Для каждого слова которое не является целым числом выводите в консоль “not a number” с новой строки.
// Под слово подразумевается совокупность символом разделенных пробелом
    public static int[] findNumbers(String text){
        String[]str=text.split(" ");
        int count =0;
        for (String s:str){
            if (isNumeric(s)) count++;

        }

        int[] numbers= new int[count];

        int index=0;
        try {
            for (String s:str){
                numbers[index]=Integer.parseInt(s);
                index++;
            }
            return numbers;



        }catch (Exception e){
            System.out.println("not a number");
        }
        return numbers;
    }

    private static boolean isNumeric(String text){
        if (text==null) return false;
        char[] chars=text.toCharArray();
        for (char ch:chars){
            if (!Character.isDigit(ch)) return false;
        }
        return true;
    }


}

