package lesson19;

public class Demo {
    public static void main(String[] args) throws Exception {
        File[] files= new File[10];
        files[0]=new File(11,"Photo","jpg",120);
        files[1]=new File(12,"Audio","mp3",700);
        String storageCountry = "US";
        String[] formatSupported={"txt","jpg","fb2","exe"};
        Storage storage = new Storage(1001,files,formatSupported,storageCountry,100000);
        Controller controller = new Controller();
        Controller.put(storage,files[2]);

    }
}
