import java.util.ArrayList;

/**
 * Created by Bharath on 7/19/15.
 */
class Node{
    int data;
    Node next = null;
    public Node(int n){
        this.data=n;
    }
}

public class SortStackElements{
    Node top;
    public SortStackElements(Node i){
        this.top=i;
    }
    void push(int d){
        Node n1 = new Node(d);
        n1.next = this.top;
        this.top= n1;
    }
    int pop(){
        int v = this.top.data;
        this.top = this.top.next;
        return v;
    }
    void sortElements(){
        ArrayList<Integer> a = new ArrayList<Integer>();
        Node itr = this.top;
        while(itr!=null){
            a.add(itr.data);
            itr=itr.next;
        }
        System.out.println(a);
    }

    public static void main(String[] args){
        Node n  = new Node(1);
        SortStackElements s1 = new SortStackElements(n);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.sortElements();
        //System.out.println(s1.pop());
    }

}
