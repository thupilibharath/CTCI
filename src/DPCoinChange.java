/**
 * Created by Bharath on 8/26/15.
 */
// Sub Structure Coins[n][m] = Coins[n][m-1] + Coins[n-input[m]][m] ---------  IMPORTANT

public class DPCoinChange {
    void getNoOfWaysToMakeChange(int[] input, int n){
        int m = input.length;int x,y;
        int[][] result = new int[n+1][m];

        for(int i=0;i<m;i++)
            result[0][i] = 1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<m;j++){
                if(i-input[j]>=0)
                 x = result[i-input[j]][j];
                else
                 x = 0;

                if(j>=1)
                    y = result[i][j-1];
                else
                    y = 0;

                result[i][j] = x+y;

            }
        }

        System.out.println("No.of Ways is: "+result[n][m-1]);

    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        DPCoinChange d1 = new DPCoinChange();
        d1.getNoOfWaysToMakeChange(arr,4);
    }
}
