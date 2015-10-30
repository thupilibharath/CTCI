/**
 * Created by Bharath on 8/20/15.
 */

//WORKS FOR POSITIVE SUM ONLY

public class Max_Linear_Sum {
    void maxSum(int[] input) {
        int sum = 0;
        int max_sum = 0;
        int n = input.length;
        for (int i = 0; i < n; i++) {
            sum += input[i];
            if (max_sum < sum)
                max_sum = sum;
            else if (sum < 0)
                sum = 0;
        }

        System.out.println("Max sum is : " + max_sum);
    }

    public static void main(String[] args) {
        Max_Linear_Sum m1 = new Max_Linear_Sum();
        int[] a = {2, -8, 3, -2, 4, -10};
        m1.maxSum(a);
    }
}
