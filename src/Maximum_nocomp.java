/**
 * Created by Bharath on 8/19/15.
 */
public class Maximum_nocomp {
    void findMax(int a, int b){
        int c = a-b;
        int k = (c>>31)&1;

        System.out.println("Maximum number is "+(a-(k*c)));
    }

    public static void main(String[] args){

        Maximum_nocomp m1 = new Maximum_nocomp();
        m1.findMax(9, 10);
        //System.out.print((int)'R'-(int)'A');
    }
}
