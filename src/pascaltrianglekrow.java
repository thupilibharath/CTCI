/**
 * Created by Bharath on 9/19/15.
 */
public class pascaltrianglekrow {
    void krow(int k) {
        int n = 1;
        int[] temp = new int[k + 1];
        int[] result = new int[k + 1];

        temp[0] = 1; temp[1] = 1;
        for (int i = 2; i < (k + 1); i++) {
            result[0] = 1; result[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (j < (i + 1)) {
                    result[j] = temp[j - 1] + temp[j];
                    //System.out.println(result[j]);
                }
            }
            for (int p = 0; p < (i + 1); p++)
                temp[p] = result[p];
        }

        System.out.println("RESULT for k = " + k);
        for (int i = 0; i <= k; i++) {
            System.out.print(result[i] + ",");
        }

    }

    public static void main(String args[]) {
        pascaltrianglekrow p1 = new pascaltrianglekrow();
        p1.krow(5);
    }



}
