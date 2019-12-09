package lesson17;

public class maxWord {
    public static void main(String[] args) {
        String str = "“@2434 rfdfd4f fff“";
        System.out.println(maxWord(str));
        System.out.println(minWord(str));
    }

    public static String maxWord(String input){
        String[] str = input.split(" ");
        if (str.length==0) return null;
        String longest=" ";
        for (String word:str){

            if (word.length()>longest.length()) {
                longest=word;

            }
        }
        return longest;
    }

    public static String minWord(String input){
        String[] str = input.split(" ");
        if (str.length==0) return null;
        String shortest=input;
        for (String word:str){
            if (word.length()<shortest.length()) {
                shortest=word;

            }
        }
        return shortest;
    }

}
