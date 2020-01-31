package lesson25;

public class GeneralDAO {
    public <T extends idEntity> void validate(T t) throws Exception {
        if (t.getId()<=0)
            throw new Exception("id can't be negative");
    }
}
