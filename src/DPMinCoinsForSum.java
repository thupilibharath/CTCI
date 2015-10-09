/**
 * Created by Bharath on 8/23/15.
 */
import java.util.HashMap;

public class DPMinCoinsForSum {
    void calcMinCoins(int[] coins, int sum){

        int n = coins.length;
        int[] min = new int[sum+1];   // Output Array
        HashMap<Integer, String> solution_map = new HashMap<>(); // Actual Result Ret
        for(int i=0;i<=sum;i++)
            min[i]=Integer.MAX_VALUE;
        min[0]=0;

        for(int i=1;i<=sum;i++){
            for(int j=0;j<n;j++){
                if(i>=coins[j]) {
                    if ((coins[j] < sum) && ((min[i - coins[j]] + 1) < min[i]))
                        min[i] = min[i - coins[j]] + 1;
                        // ADD SOLUTION TO Hash Map
                        if(solution_map.containsKey(i))
                            solution_map.put(i,solution_map.get(i)+", "+Integer.toString(coins[j]));
                        else
                            solution_map.put(i,Integer.toString(coins[j]));

                }
            }
        }

        System.out.println("Min coins required to get a sum of "+sum+" is: "+min[sum]);
        System.out.println("Actual coins are " + solution_map.get(sum));
    }

    public static void main(String[] args){
        int[] a={1,3,5};
        DPMinCoinsForSum d1 = new DPMinCoinsForSum();
        d1.calcMinCoins(a,11);
    }
}
