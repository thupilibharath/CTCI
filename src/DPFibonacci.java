/**
 * Created by Bharath on 8/25/15.
 */
import java.util.ArrayList;
public class DPFibonacci {
    void getFibonacci(int a){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<=a;i++){
            if(i<=1){
                result.add(i);
            }
            else{
                result.add(result.get(i-1)+result.get(i-2));
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args){
        DPFibonacci d1 = new DPFibonacci();
        d1.getFibonacci(40);
    }
}
