package lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String test = "someStringExample";

        //System.out.println(test.isEmpty());
        //System.out.println("");
        //System.out.println(test.length());
        //System.out.println(test.charAt(0));
        //String res = test.replace("me","T");
        //System.out.println(res);
        //System.out.println(test.replaceAll("me","T"));
        //System.out.println(test.contains("meT"));

        String phrase = "hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));
        System.out.println(" test ".trim());
        System.out.println(phrase.substring(5));
        System.out.println(phrase.substring(5,10).trim());
        //System.out.println(test.toUpperCase());
        //System.out.println(test.toLowerCase());


    }
}
