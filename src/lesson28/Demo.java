package lesson28;

import lesson28.task2.IsActiveComparator;

import java.util.ArrayList;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Capability capability1=new Capability(1001,"test","arrr",true,new Date());
        Capability capability2=new Capability(1005,"test","arrr",false,new Date());
        Capability capability3=new Capability(900,"test","arrr",false,new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);

        System.out.println(capabilities);

        capabilities.sort(new IsActiveComparator());

        System.out.println(capabilities);
    }
}
