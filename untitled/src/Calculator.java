import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println(result);
    }

    private static int getInt() {
        System.out.println("Enter number: ");
        int num;
        if (scanner.hasNext())
            num=scanner.nextInt();
        else {
            System.out.println("Error");
            scanner.next();//рекурсия
            num=getInt();
        }
        return num;
    }

    private static char getOperation() {
        System.out.println("Enter operation: ");
        char operation;
        if (scanner.hasNext())
            operation=scanner.next().charAt(0);
        else {
            System.out.println("Error");
            scanner.next();//рекурсия
            operation=getOperation();
        }
        return operation;
    }

    private static int calc(int num, int num1, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num + num1;
                break;
            case '-':
                result = num - num1;
                break;
            case '*':
                result = num*num1;
                break;
            case '/':
                result = num/num1;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result=calc(num, num1, operation);//рекурсия
        }
        return result;
    }
}
