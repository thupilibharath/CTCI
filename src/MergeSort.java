/**
 * Created by Bharath on 10/3/15.
 */
import java.util.*;

public class MergeSort {

    private int[] input;
    private int[] temp;
    private int length;

    private void mergeSort(int[] c)
    {
        input = c;
        length = c.length;
        temp = new int[length];
        doSort(0, length-1);

    }

    private void doSort(int low, int high)
    {
        if(low<high) {
            int mid = low + ((high - low) / 2);
            doSort(low, mid);//left half
            doSort((mid + 1), high);//right half
            mergeParts(low, mid, high);
        }
    }

    private void mergeParts(int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;

    /* create temp arrays */
        int[] L = new int[n1]; int[] R = new int[n2];

    /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            L[i] = input[l + i];
        for (j = 0; j < n2; j++)
            R[j] = input[m + 1+ j];

    /* Merge the temp arrays back into arr[l..r]*/
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                input[k] = L[i];
                i++;
            }
            else
            {
                input[k] = R[j];
                j++;
            }
            k++;
        }

    /* Copy the remaining elements of L[], if there are any */
        while (i < n1)
        {
            input[k] = L[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there are any */
        while (j < n2)
        {
            input[k] = R[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args)
    {
        System.out.println("Hello World");
        int[] a = {0,2,9,6,53,27,8,16};
        MergeSort s = new MergeSort();
        //System.out.println(a[9]);
        s.mergeSort(a);
        for(int i=0;i<a.length;i++)
            System.out.println(s.input[i]);



    }

}
