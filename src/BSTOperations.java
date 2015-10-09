
/**
 * Created by Bharath on 8/26/15.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashMap;

class node{
    int data;
    node left;
    node right;

    node newNode(int d){
        node n = new node();
        n.data = d;
        n.left=null;
        n.right=null;
        return n;
    }
}


public class BSTOperations {

    static int preIndex = 0;
    node build = new node();
    void inorder(node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    int getHeight(node root){
        if(root==null)
            return 0;
        else
            return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    boolean isBalanced(node root){
        if(getHeight(root.left)==getHeight(root.right))
            return true;
        else
            return false;
    }

    HashMap getLevelLL(node root){
        Queue<node> q1 = new LinkedList<>();
        HashMap<Integer,ArrayList> result = new HashMap<>();
        q1.add(root);
        int counter =1;
        int level = 1;
        while(!q1.isEmpty()){
            ArrayList<Integer> a1 = new ArrayList<>();
            for(int i=0;i<counter;i++) {
                node temp = q1.poll();
                if(temp!=null)
                a1.add(temp.data);

                if(temp.left!=null)
                    q1.add(temp.left);
                if(temp.right!=null)
                    q1.add(temp.right);
            }
            //System.out.println(a1);
            result.put(level, new ArrayList<>(a1)); // Important to create new object
            //System.out.println(result);
             a1.clear();
            counter = counter*2;
            level++;
        }

        return result;
    }

    node getFirstCommonAnscestor(node root, int a, int b){
        if(a<=root.data&&b>=root.data)
            return root;
        else if(a<=root.data&&b<=root.data)
            return getFirstCommonAnscestor(root.left, a, b);
        else
            return getFirstCommonAnscestor(root.right, a, b);
    }

    boolean isSubTree(node t1, node t2){
        if(t2==null&&t1!=null){
            return true;
        }

        else if(t1==null){
            return false; //First Tree Empty
        }

        else if(t1.data==t2.data){
            if(matchTree(t1,t2))
                return true;
        }

        return(isSubTree(t1.left, t2)||isSubTree(t1.right, t2));

    }

    boolean matchTree(node t1, node t2){     // Sub-Function for finding whether trees are subtrees are not
        if(t1==null&&t2==null){
            return true;// Traversing both trees is done
        }

        if(t1==null&&t2!=null){
            return false;// t1 is traversed fully but t2 is remaining
        }

        if(t1.data!=t2.data){
            return false;
        }

        return(matchTree(t1.left, t2.left)&&matchTree(t1.right, t2.right));
    }

    void findSumPaths(node t, int sum, ArrayList<Integer> buffer, int level){
        if(t==null)
            return;
        int tmp = sum;
        buffer.add(t.data);
        //System.out.println(buffer);
        for(int i=level;i>-1;i--){
            tmp = tmp - buffer.get(i);
            if(tmp == 0){
                for(int j= i;j<=level;j++)
                    System.out.print(buffer.get(j)+" ");
            }
            //System.out.println();
        }

        ArrayList<Integer> b1 = new ArrayList<>(buffer);
        ArrayList<Integer> b2 = new ArrayList<>(buffer);

        findSumPaths(t.left,sum,b1,level+1);
        findSumPaths(t.right,sum,b2,level+1);
    }

    public node treeToLlUtil(node root){
        if(root==null)
            return root;

        if(root.left!=null){
            node left = treeToLlUtil(root.left);

            while(left.right!=null)
                left=left.right;

            left.right=root;
            root.left=left;
        }

        if(root.right!=null){
            node right = treeToLlUtil(root.right);

            while(right.left!=null)
                right=right.left;

            right.left = root;
            root.right=right;
        }

        return root;
    }

    public node treeToLl(node root){
        if(root==null)
            return root;
        node tree = treeToLlUtil(root);

        while(root.left!=null)
            root=root.left;

        return root;
    }

    public  node buildTree(int[] in, int[] pre, int inStart, int inEnd){


        if(inStart>inEnd)
            return null;

        node tnode = build.newNode(pre[preIndex++]);

        if(inStart==inEnd)
            return tnode;

        int inIndex = search(in,inStart,inEnd,tnode.data);

        tnode.left = buildTree(in,pre, inStart,inIndex-1);
        tnode.right=buildTree(in,pre,inIndex+1,inEnd);

        return tnode;
    }

    int search(int[] in, int inStart, int inEnd, int value){
        for(int i=inStart; i<=inEnd;i++){
            if(value==in[i])
                return i;
        }
        return 0;
    }

    public static void main(String[] args){
        node r = new node();
        node r1 = r.newNode(8);
        r1.left = r.newNode(4);
        r1.right = r.newNode(10);
        r1.left.left = r.newNode(2);
        r1.left.right = r.newNode(6);
        r1.right.left = r.newNode(9);
        r1.right.right = r.newNode(11);
        //r1.right.right.right = r.newNode(13);

        node r2 = r.newNode(4);
        r2.left = r.newNode(2);
        r2.right = r.newNode(6);

        BSTOperations tree = new BSTOperations();
        tree.inorder(r1);

        int height = tree.getHeight(r1);
        System.out.println("Height of tree is: "+height);

        if(tree.isBalanced(r1))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");

        System.out.println(tree.getLevelLL(r1));

        System.out.println("Common Anscestor of 2,6 is: " + tree.getFirstCommonAnscestor(r1, 2, 6).data);

        System.out.println("Is r2 subtree of r1: " + tree.isSubTree(r1, r2));

        ArrayList<Integer> buf = new ArrayList<>();

        tree.findSumPaths(r1, 6, buf, 0);

        node ll = tree.treeToLl(r1);

        System.out.println("*****BST TO LINKED LIST*******");

        while(ll.right!=null) {
            System.out.println(ll.data);
            ll=ll.right;
        }

        System.out.println("*****BUILT TREE*******");

        int[] in = {1,2,3,4,5};
        int[] pre = {5,4,3,2,1};

        node newTree = tree.buildTree(in,pre,0,4);


        System.out.println("Root is "+newTree.data);

        tree.inorder(newTree);

    }
}
