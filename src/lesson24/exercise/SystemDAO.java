package lesson24.exercise;

public class SystemDAO {
    private System[] systems=new System[5];
    public System save(System system){
        int index=0;
        for (System sys:systems){
            if (sys==null){
                systems[index]=system;
                return systems[index];
            }
            index++;
        }
        return null;
    }
}
