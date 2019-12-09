package lesson2;
import java.util.Scanner;
public class Car {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = in.nextInt();
        int factorial = 1;
        String s = n + "! = 1";
        for (int i = 2; i <= n; i++) {
            factorial *= i;
            s += "*" + i;
        }
        s += " = ";
        System.out.println(s + factorial);



    }
}
