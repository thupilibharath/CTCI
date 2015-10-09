/**
 * Created by Bharath on 8/27/15.
 */
/*import java.util.ArrayList;
public class StackOperations {
    int[] Stack = new int[5];
    int size = 5;
    int top =0;
    void push(int n){
        if(top==4)
            System.out.println("Overflow");
        else
            Stack[++top] = n;

    }

    void pop(){
        if(top)
    }
}
*/
import java.util.*;

class StackOperations{
    ArrayList<Integer> mystack = new ArrayList<>();
    ArrayList<Integer> minstack  = new ArrayList<>();
    int top=0;int top1=0;
    int size = 10;
    public void push(int a){
        if(mystack.size()<size){
        mystack.add(a);
        top++;
            if(minstack.size()==0){
                minstack.add(a);top1++;
            }
            if(minstack.size()>0&&minstack.get(top1 - 1)>=a){
                minstack.add(a);top1++;
            }


        }
        else
            System.out.println("Stack Overflow");
    }

    public int pop(){
        if(mystack.size()>0){
        int ret = mystack.get(top-1);
            System.out.println(ret);
            if(ret==minstack.get(top1-1)){

                minstack.remove(top1-1);
                top1--;
            }
            mystack.remove(top - 1);
            top--;
            return ret;
        }
        else
            System.out.println("Stack Underflow");
        return 0;
    }

    public void getMin(){
        System.out.println(minstack.get(top1 - 1));
    }

    public static void main(String[] args){
        StackOperations s1 = new StackOperations();
        s1.push(1);
        s1.push(2);
        s1.push(45);
        s1.push(0);
        s1.push(37);
        s1.getMin();
        s1.pop();
        s1.getMin();
        s1.pop();
        s1.getMin();

    }

}