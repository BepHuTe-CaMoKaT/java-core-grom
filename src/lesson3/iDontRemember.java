package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class iDontRemember {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 2 numbers:  ");
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] array = new int[a][b];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rnd.nextInt(10) + 1;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();

        }
        System.out.println("Enter ");
        int count = in.nextInt();
        switch (count) {
            case 1:

            case 2:
                System.out.println(Arrays.deepToString(array));
        }
    }
}
