/**
 * Created by Bharath on 8/26/15.
 */
public class DPMinCostMatrixPath {
    void getMinCostPath(int[][] input, int m, int n){

        int[][] result = new int[m+1][n+1];

        result[0][0] = input[0][0];

        for(int i=1;i<=m;i++)
            result[i][0] = result[i-1][0] + input[i][0];

        for(int j=1;j<=n;j++)
            result[0][j] = result[0][j-1] + input[0][j];

        for(int i =1;i<=m;i++){
            for(int j=1;j<=n;j++){
                result[i][j] = Math.min(result[i-1][j-1],result[i-1][j]);
                result[i][j] = Math.min(result[i][j],result[i][j-1]) + input[i][j];

            }
        }

        System.out.println("Required minimum cost is: "+result[m][n]);
    }

    public static void main(String[] args){
        int[][] arr = {{1,2,3},{4,8,2},{1,5,3}};
        DPMinCostMatrixPath d1 = new DPMinCostMatrixPath();
        d1.getMinCostPath(arr,2,2);
    }
}
