import java.util.ArrayList;

/**
 * Created by Bharath on 10/1/15.
 */
public class DPMatrixPaths {
    public void printPaths(int[][] src){

        int m = src.length; String s;
        int n = src[0].length;
        int[][] res = new int[m][n];
        //System.out.println(m);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    res[i][j]=1;
                }
                else {
                   res[i][j] = res[i][j-1]+res[i-1][j]+res[i-1][j-1];
                }

            }
        }

        System.out.println(res[m-1][n-1]);

    }

    public static void main(String[] args){
        DPMatrixPaths d1 = new DPMatrixPaths();
        int[][] a = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                a[i][j]=(i+j);
            }
        }
        d1.printPaths(a);
    }
}
