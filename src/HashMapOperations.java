import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

/**
 * Created by Bharath on 10/1/15.
 */
public class HashMapOperations {
    public void getOprs(HashMap<Integer,String> h){
        Set<Integer> keys = h.keySet();
        for(int i:keys){

            System.out.println(h.get(i));
        }
    }

    public static void main(String[] args){
        HashMap<Integer, String> m1 = new HashMap<>();
        m1.put(1,"Hi");
        m1.put(2,"Hello");
        m1.put(3,"There??");
        HashMapOperations h = new HashMapOperations();
        h.getOprs(m1);
    }
}
