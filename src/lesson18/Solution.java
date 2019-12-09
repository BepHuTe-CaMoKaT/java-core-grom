package lesson18;

public class Solution {
    public static void main(String[] args) {
        findNumbers("1.4 41eee e1we 4,55");
    }

    public static int[] findNumbers(String text){
        String[] str=text.split("");
        int count=0;
        for (String s:str){
            if (!isNumeric(s)){
                System.out.println("not a number");
            }
            count++;
        }
        int[] numbers=new int[count];
        int index=0;
        for (String s:str){
            if (isNumeric(s)){
                numbers[index]=Integer.parseInt(s);
                index++;

            }
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
