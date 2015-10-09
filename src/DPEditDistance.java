/**
 * Created by Bharath on 8/26/15.
 */
public class DPEditDistance {
    void getMinCost(String a, String b){

        int cost1, cost2, cost3;
        int m = a.length();
        int n = b.length();

        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();

        int[][] result = new int[m+1][n+1];

        // Initialize Result
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j] = -1;
            }
        }

        //Base Case result[0][j] = j -----   Insert
        for(int j=0;j<n;j++){
            result[0][j] = j;
        }

        //Base Case result[i][0] = i ----- Delete
        for(int i=0;i<m;i++){
            result[i][0] = i;
        }

        //Main Logic
        for(int i=1;i<m;i++){
            for(int j =1;j<n;j++ ){
                if(a1[i]==b1[j])
                    cost1 = 0;
                else
                    cost1 = 1;
                cost2=1;cost3=1;
                result[i][j] = Math.min((result[i-1][j-1]+cost1),(result[i][j-1]+cost2));
                result[i][j] = Math.min((result[i][j]),(result[i-1][j]+cost3));

            }
        }

        System.out.println("Minimum cost is: "+result[m-1][n-1]);

    }

    public static void main(String[] args){
        DPEditDistance d1 = new DPEditDistance();
        d1.getMinCost("SUNDAY", "SATURDAY");
    }
}
