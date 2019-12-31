package lesson3;
import java.util.Random;
import java.util.Scanner;

public class iDontRemember {
    public static void main(String[] args) {
        double average=0;
        int sum = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 2 numbers:  ");
        int a=in.nextInt();
        int b=in.nextInt();
        int[][]array=new int[a][b];
        Random rnd=new Random();
        for (int i=0;i<array.length;i++){
            for (int j =0; j<array[i].length;j++){
                array[i][j]=rnd.nextInt(10)+1;
                sum+=array[i][j];
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();

        }
        average=(float)sum/array.length;
        System.out.println(average+" is average of array!");


    }
}
