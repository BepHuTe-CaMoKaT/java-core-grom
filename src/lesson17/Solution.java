package lesson17;

public class Solution {//метод countWords для подсчета слов во входящем стринге.

    public static void main(String[] args) {
        String str = "http://south.com";
        System.out.println(countWords(str));
        System.out.println(maxWord(str));
        System.out.println(minWord(str));
        System.out.println(mostCountedWord(str));
        System.out.println(validate(str));

        System.out.printf("Max of %d, %d and %d is %d\n\n",
                3, 4, 5, maximum(3, 4, 5));

    }

    public static int countWords(String input) {
        String[] words = input.split(" ");
        if (words.length == 0) return 0;
        int count = 0;

        for (String strings : words) {

            if (strings.length() > 0 && checkLetter(strings)) count++;
        }
        return count;
    }




    //методы для поиска самого длинного и самого короткого слова во входящем стринге
    public static String maxWord(String input) {
        String[] str = input.split(" ");
        if (str.length == 0) return null;
        String longest = null;
        for (String word : str) {

            if (word.length() > 0 && checkLetter(word)) {
                longest = word;
                break;
            }
        }
        if (longest == null) return null;

        for (String word : str) {
            if (word.length() > longest.length() && checkLetter(word)) longest = word;
        }
        return longest;
    }

    public static String minWord(String input) {
        String[] str = input.split(" ");
        if (str.length == 0) return null;
        String shortest = null;
        for (String word : str) {

            if (word.length() > 0 && checkLetter(word)) {
                shortest = word;
                break;
            }

        }
        if (shortest == null) return null;

        for (String word : str) {
            if (word.length() < shortest.length() && word.length() > 0 && checkLetter(word)) shortest = word;
        }
        return shortest;
    }

    public static String mostCountedWord(String input) {
        String[] str = input.split(" ");
        if (str.length == 0) return null;
        int finalCount = 0;
        int tempCount = 0;
        String mostlyUsedWord = null;
        for (String word : str) {
            tempCount = 0;
            for (String w : str) {
                if (word.equals(w) && word.length() > 0 && checkLetter(w)) {
                    tempCount++;
                }
            }
            if (tempCount > finalCount) {
                finalCount = tempCount;
                mostlyUsedWord = word;
            }
        }
        return mostlyUsedWord;

    }

    public static boolean validate(String address) {
        if (!address.startsWith("http://") && !address.startsWith("https://")) return false;
        if (!address.endsWith(".com") && !address.endsWith(".net") && !address.endsWith(".org")) return false;

        address = isValid(address, new String[]{"http://", "https://"});
        address = address != null && address.startsWith("www.") ? address.replaceFirst("www.", "") : address;
        address = isValid(address, new String[]{".com", ".net", ".org"});
        return address != null && address.length() > 0 && checkLetter(address);
    }

    private static String isValid(String address, String[] parts) {
        for (String part : parts) {
            if (address.contains(part)) {
                address = address.replaceFirst(part, "");
                return address;
            }
        }
        return null;
    }

    private static boolean checkLetter(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isDigit(c)) return false;
        }
        return true;
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) max = y;
        if (z.compareTo(max) > 0) max = z;
        return max;
    }


}
