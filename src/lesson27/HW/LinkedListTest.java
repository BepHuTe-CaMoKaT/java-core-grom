package lesson27.HW;

import java.util.LinkedList;

public class LinkedListTest {
    public static void useList(){
        LinkedList<Order> list = new LinkedList<>();
        LinkedList<Order> list1 = new LinkedList<>();

        Order order = new Order(1001,120,"USD","phone","test");
        Order order1 = new Order(1002,1300,"EUR","laptop","test");
        Order order2 = new Order(1003,101100,"RUB","car","test");
        Order order3 = new Order(1004,1010,"USD","food","test");
        Order order4 = new Order(1005,12000,"EUR","piano","test");
        list1.add(order);


        list.add(order);
        list.add(1,order1);
        list.remove(1);
        list.remove(order2);
        list.addAll(list1);
        list.subList(1,2);
        list.set(1,order3);
        System.out.println(list.contains(order4));
        System.out.println(list.toString());
        list.clear();
    }

    public static void main(String[] args) {
        useList();
    }
}
