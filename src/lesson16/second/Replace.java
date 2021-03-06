package lesson16.second;

import java.util.Arrays;

public class Replace {
    public static void main(String[] args) {
        String test = "There is something new or jot sdf sdf sdf word Test op or";
        System.out.println(deleteDuplicates(test));
        System.out.println(Arrays.toString(countDuplicates(test, new String[]{"test", "here", "not"})));
        String str  = "test str here was here two times or not no test";
        System.out.println(replace(str,"here", "PPP"));
    }

    public static String deleteDuplicates(String input) {

        //находим повторения
        //удаляем их
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) words[j] = "";
            }
        }
        String res = "";
        for (String word : words) {
            res += word;
            if (!word.isEmpty()) res += " ";
        }
        return res;
    }

    public static int[] countDuplicates(String input, String[] words) {
        String[] strings = input.split(" ");
        int[] res = new int[words.length];
        for (String string : strings) {
            for (int i = 0; i < words.length; i++) {
                if (string.equals(words[i])) res[i]++;
            }
        }
        return res;
    }


    public static String replace(String input, String target, String replacement) {
        int[] indexes = findStartIndexes(input.toCharArray(),target.charAt(0));
        if (indexes.length==0) return input;
        for (int index:indexes){
            if (checkReplace(input,target,index)){
                replace(input, target, replacement,index);
            }
        }
        return input;
    }

    private static String replace(String input, String target, String replacement,int index){
        char[] res1= new char[index];
        for (int i=0;i<index;i++){
            res1[i]=input.toCharArray()[i];
        }
        char[]res3=new char[input.length()-res1.length-target.length()];
        for (int i=0, j = res1.length + target.length();i<res3.length&&j<input.length();i++){
            res3[i]=input.toCharArray()[j];
        }
        return new String(res1) + replacement + new String(res3);
    }

    private static boolean checkReplace(String input, String target, int index) {
        char[] inputChars=input.toCharArray();
        char[] replaceChars=target.toCharArray();
        for (int i = 0; i<replaceChars.length&&index<inputChars.length;i++,index++){
            if (inputChars[index]!=replaceChars[i])return false;
        }
        return true;
    }

    private static int[] findStartIndexes(char[] inputChars, char beginningChar){
        int count = 0;
        for (char ch:inputChars){
            if (ch==beginningChar) count++;
        }
        int[] indexes=new int[count];
        int in =0;
        int index=0;
        for (char ch:inputChars){
            if (ch==beginningChar){
                indexes[in]=index;
                in++;
            }
            index++;
        }
        return indexes;
    }


}
