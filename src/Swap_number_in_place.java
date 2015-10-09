/**
 * Created by Bharath on 8/19/15.
 */
public class Swap_number_in_place {

    void swap(int a, int b){

        System.out.println("****BEFORE SWAPPING****");
        System.out.print("a = ");
        System.out.println(a);

        System.out.print("b = ");
        System.out.println(b);

        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("****BEFORE SWAPPING****");
        System.out.print("a = ");
        System.out.println(a);

        System.out.print("b = ");
        System.out.println(b);

    }

    public static void main(String[] args){
        Swap_number_in_place s1 = new Swap_number_in_place();
        s1.swap(9,10);
    }
}
