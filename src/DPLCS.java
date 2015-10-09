/**
 * Created by Bharath on 8/25/15.
 */
public class DPLCS {
    void getLcs(String a, String b){
        int m = a.length();
        int n = b.length();

        int[][] result = new int[m+1][n+1];

        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();

            for(int j=0;j<=n;j++){        for(int i=0;i<=m;i++){

                if(i==0||j==0){
                    result[i][j]=0;
                }
                else if((int)a1[i-1]==(int)b1[j-1]){
                    result[i][j] = 1 + result[i-1][j-1];
                }
                else{
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }

        System.out.println(result[m][n]);
    }

    public static void main(String[] args){
        DPLCS d1 = new DPLCS();
        d1.getLcs("AGGTAB", "GXTXAYB");
    }
}
