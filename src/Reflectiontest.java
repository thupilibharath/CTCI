/**
 * Created by Bharath on 10/3/15.
 */
public class Reflectiontest {
    public static void main(String[] args) {
        try {

            Class cls = Class.forName("MergeSort");
            Object obj = cls.newInstance();
            //Method m = cls.getDeclaredMethod();
            System.out.println(cls.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
