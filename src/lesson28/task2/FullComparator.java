package lesson28.task2;

import lesson28.Capability;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability capability, Capability t1) {
        if (!capability.getChannelName().equals(t1.getChannelName())) return capability.getChannelName().compareTo(t1.getChannelName());
        else if (!capability.getFingerprint().equals(t1.getFingerprint())) return capability.getFingerprint().compareTo(t1.getFingerprint());
        else if (!capability.getDateCreated().equals(t1.getDateCreated())) return capability.getDateCreated().compareTo(t1.getDateCreated());
        else return 0;
    }
}
