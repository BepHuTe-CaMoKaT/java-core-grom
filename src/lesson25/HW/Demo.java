package lesson25.HW;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO<Object> generalDAO=new GeneralDAO<>();
        Object object=new Object();
        generalDAO.save(object);
        generalDAO.getAll();

    }
}
