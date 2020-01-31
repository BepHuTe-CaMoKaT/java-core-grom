package lesson29;

import lesson27.HW.Order;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.IntFunction;

public class HashSetTest {
    public static void useHashSet(){
        Set<Order> list = new HashSet<>();
        Set<Order> list1 = new HashSet<>();

        Order order = new Order(1001,120,"USD","phone","test");
        Order order1 = new Order(1002,1300,"EUR","laptop","test");
        Order order2 = new Order(1003,101100,"RUB","car","test");
        Order order3 = new Order(1004,1010,"USD","food","test");
        Order order4 = new Order(1005,12000,"EUR","piano","test");
        list1.add(order4);

        list.add(order);
        list.add(order1);
        list.add(order2);
        list.add(order3);
        list.add(order4);
        list.remove(order);
        list.retainAll(list1);
        list.toArray();
        System.out.println(list.size());
        System.out.println(list);
//Iterator - способ извлечения элеменов из Set и не только
        Iterator<Order> orderIterator = list.iterator();
        while (orderIterator.hasNext()) System.out.println(orderIterator.next());
    }

    public static void main(String[] args) {
        useHashSet();
    }
}
