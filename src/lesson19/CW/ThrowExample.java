package lesson19.CW;

public class ThrowExample {
    private static String[] array={"test", "test1", "testqwd", "adsasf","sdfsdf",null};

    public static void main(String[] args) {
        //test();
        useOfTestMethod();
    }
    private static void test() throws Exception{
        for (String element:array){
            if (element==null)
                throw new Exception("null is detected");
        }
        System.out.println("done!");
    }
    private static void useOfTestMethod(){
        try {
            test();
        }catch (Exception e){
            System.err.println("error:"+e.getMessage());
        }
    }
}
