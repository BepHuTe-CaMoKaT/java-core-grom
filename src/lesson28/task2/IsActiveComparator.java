package lesson28.task2;

import lesson28.Capability;

import java.util.Comparator;

public class IsActiveComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability capability, Capability t1) {
        if (capability.isActive()&&!t1.isActive()) return -1;
        else if ((capability.isActive()&&t1.isActive())||(!capability.isActive()&&!t1.isActive())) return 0;
        else return 1;
    }
}
