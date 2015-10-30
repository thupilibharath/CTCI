/**
 * Created by Bharath on 09/02/15.
 */

import java.util.*;

public class Inversions {

    private int[] input;
    private int[] temp;
    private int length;
    //int count = 0;

    private void mergeSort(int[] c) {
        input = c;
        length = c.length;
        temp = new int[length];
        System.out.println(doSort(input, 0, length - 1));

    }

    private int doSort(int[] input, int low, int high) {
        int count = 0;

        if (low < high) {
            int mid = low + ((high - low) / 2);
            count = doSort(input, low, mid); //left half
            count += doSort(input, (mid + 1), high); //right half
            count += mergeParts(input, low, mid, high);
        }
        return count;
    }


    private int mergeParts(int [] c, int low, int mid, int high) {
        int count = 0;
        //for(int i=low;i<=high;i++)
        //  temp[i] = input[i];
        int i = low;
        int j = (mid + 1);
        int k = low;
        while (i <= mid && j <= high) {
            if (c[i] <= c[j]) {
                temp[k] = c[i];
                i++;
            } else {
                temp[k] = c[j];
                count += (mid - i + 1);
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = c[i];
            k++;
            i++;
        }
        while (j <= high) {
            temp[k] = c[j];
            k++;
            j++;
        }
        for (i = low; i <= high; i++)
            c[i] = temp[i];
        return count;


    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = {0, 5, 2, 7, 56, 21, 43, 7, 9, 3};
        Inversions s = new Inversions();
        System.out.println(a[9]);
        s.mergeSort(a);
        for (int i = 0; i < 10; i++)
            System.out.print(s.input[i]);
        System.out.println("\n");

        //System.out.println(s.count);



    }

}
