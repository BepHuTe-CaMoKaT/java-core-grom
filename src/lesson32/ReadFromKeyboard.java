/*
В классе ReadFromKeyboard напишите два метода для считывания данных с
клавиатуры.
Методы должны писать пользователю в консоль "Please enter your name",
после чего давать возможность ввести свое имя, в случае ввода, п
рограмма должна писать в консоль "Hello, -подставить введенное имя-!".
Первый метод должен работать использую Scanner, второй метод должен использовать
BufferedReader
Сигнатура методов:
readKeyboardWithScanner()
readKeyboardWithIOStream()
 */
package lesson32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException{

        readKeyboardWithIOStream();
        readKeyboardWithScanner();
    }

    public static void readKeyboardWithScanner() {
        System.out.println("Please enter your name: ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, " + scanner.nextLine() + "!");

        scanner.close();
    }

    public static void readKeyboardWithIOStream()throws IOException {
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(reader);


        System.out.println("Please enter your name: ");
        System.out.println("Hello, " +  br.readLine() + "!");
    }


}