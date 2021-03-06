package lesson28.task2;

import lesson28.Capability;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability capability, Capability t1) {
        if (!capability.getDateCreated().equals(t1.getDateCreated())) return capability.getDateCreated().compareTo(t1.getDateCreated());
        else return 0;
    }
}
