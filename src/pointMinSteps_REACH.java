import java.util.ArrayList;

/**
 * Created by Bharath on 9/7/15.
 */
public class pointMinSteps_REACH {
    public int minSteps(ArrayList<Integer> X, ArrayList<Integer> Y){
        int n = X.size();
         int count  = 0;
        for (int i = 0;i<(n-1);i++){
            int x1 = X.get(i);
            int x2 = X.get(i+1);
            int y1 = Y.get(i);
            int y2 = Y.get(i+1);



        }

        return count;
    }
}
