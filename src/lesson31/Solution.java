package lesson31;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<Character, Integer> countSymbols(String text) throws Exception {
        if (text.isEmpty() || text == null) throw new Exception("Error");
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = text.toCharArray();
        for (Character character : chars) {
            if (Character.isLetter(character)) {
                map.put(character, map.get(character) == null ? 1 : map.get(character) + 1);
            }
        }
        return map;
    }
    public static Map<String,Integer> words(String text) throws Exception{
        if (text.isEmpty()||text==null) throw new Exception("Error");
        Map<String,Integer> map=new HashMap<>();

        String[] strings=text.split(" ");
        for (String string1:strings){
            if (string1.length()>1) map.put(string1,map.get(string1)==null?1:map.get(string1)+1);
        }
        return map;
    }

}
