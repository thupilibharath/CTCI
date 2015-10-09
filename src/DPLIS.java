/**
 * Created by Bharath on 8/25/15.
 */
public class DPLIS {
    void getLis(int[] input){
        int[] lis = new int[input.length];
        int size = input.length;
        int max_lis=1;

        for(int i=0;i<size;i++)
            lis[i]=1;

        for(int i=1;i<size;i++){
            for(int j=0;j<i;j++){
                if((input[i]>input[j])&&(lis[i]<(lis[j]+1))){
                    lis[i]=lis[j]+1;
                }
            }
            if(max_lis<lis[i])
                max_lis=lis[i];
        }

        System.out.println("Length of LIS is "+max_lis);
    }

    public static void main(String[] args){
        DPLIS d1 = new DPLIS();
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        d1.getLis(arr);
    }
}
