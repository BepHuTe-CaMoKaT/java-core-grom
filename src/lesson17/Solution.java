package lesson17;

public class Solution {//метод countWords для подсчета слов во входящем стринге.
    public static void main(String[] args) {
        String str = "How many poisons creepy venomous things around Australia?";
        System.out.println(countWords(str));
        System.out.println(maxWord(str));
    }

    public static int countWords(String input){
        if (input==null||input.isEmpty())return 0;
        String[] words = input.split(" ");
        return words.length;
    }


//методы для поиска самого длинного и самого короткого слова во входящем стринге
    public static String maxWord(String input){
        String[] str = input.split(" ");
        String longest=" ";
        for (int i=0;i<str.length;i++){
            for (int j = i+1;j<str.length;j++){
                if (str[i].length()>str[j].length()) longest=str[i];
            }
        }
        return longest;
    }

    public static String minWord(String input){
        String[] str = input.split(" ");
        String shortest=" ";
        for (int i=0;i<str.length;i++){
            for (int j = i+1;j<str.length;j++){
                if (str[i].length()<str[j].length()) shortest=str[i];
            }
        }
        return shortest;
    }
}
