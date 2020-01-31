package lesson27;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class TestPerformance {
    public static void main(String[] args) {
        testAddMethod();
        testRemoveMethod();
        testGetMethod();
    }

    private static void testAddMethod(){
        ArrayList<String> arrayList = new ArrayList<>();
        Date start=new Date();
        for (int i = 0; i < 1_000_00; i++) {
            arrayList.add(i,String.valueOf(i));
        }
        Date finish = new Date();

        System.out.println(finish.getTime()-start.getTime());

        LinkedList<String> linkedList = new LinkedList<>();
        Date start1=new Date();
        for (int i = 0; i < 1_000_00; i++) {
            linkedList.add(i,String.valueOf(i));
        }
        Date finish1 = new Date();

        System.out.println(finish1.getTime()-start1.getTime());
    }

    private static void testRemoveMethod(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 1_000_00; i++) {
            arrayList.add(i,String.valueOf(i));
        }
        Date start=new Date();
        for (int i = 0; i < 1_000_00; i++) {
            arrayList.remove(0);
        }
        Date finish = new Date();

        System.out.println(finish.getTime()-start.getTime());

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 1_000_00; i++) {
            linkedList.add(i,String.valueOf(i));
        }
        Date start1=new Date();
        for (int i = 0; i < 1_000_00; i++) {
            linkedList.remove(0);
        }
        Date finish1 = new Date();

        System.out.println(finish1.getTime()-start1.getTime());
    }

    private static void testGetMethod(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 1_000_00; i++) {
            arrayList.add(i,String.valueOf(i));
        }
        Date start=new Date();
        for (int i = 0; i < 1_000_00; i++) {
            arrayList.get(0);
        }
        Date finish = new Date();

        System.out.println(finish.getTime()-start.getTime());

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 1_000_00; i++) {
            linkedList.add(i,String.valueOf(i));
        }
        Date start1=new Date();
        for (int i = 0; i < 1_000_00; i++) {
            linkedList.get(0);
        }
        Date finish1 = new Date();

        System.out.println(finish1.getTime()-start1.getTime());
    }
}
