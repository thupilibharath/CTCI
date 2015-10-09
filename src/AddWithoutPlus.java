/**
 * Created by Bharath on 8/21/15.
 */
public class AddWithoutPlus {
    int addWithoutAritmetic(int a, int b){
        if(b==0)
            return a;

        int sum = a^b;
        int carry = (a&b)<<1;
        return addWithoutAritmetic(sum, carry);
    }

    public static void main(String[] args){
        AddWithoutPlus a1 = new AddWithoutPlus();
        System.out.print("Sum is " + a1.addWithoutAritmetic(210, 413));
    }
}
