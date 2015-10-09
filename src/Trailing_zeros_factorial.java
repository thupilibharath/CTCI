/**
 * Created by Bharath on 8/19/15.
 */
public class Trailing_zeros_factorial {
    void computeZeros(double input){
        double count = 0;
        double a = 1;


        while(a<=input){
            count = count + this.computeFives(a);
            a++;
        }

        System.out.print("Number of trailing zeros in "+(int)input+"! is : ");
        System.out.print((int)count);
    }

    double computeFives(double b){
        int tempcount = 0;
        while(b%5==0){
           // System.out.println(tempcount);
            tempcount++;
            b = b/5;
        }
        return tempcount;
    }

    public static void main(String[] args){
        Trailing_zeros_factorial t1 = new Trailing_zeros_factorial();
        t1.computeZeros(100);
        //System.out.println(t1.computeFives(50));
    }
}
