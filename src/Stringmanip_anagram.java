/**
 * Created by Bharath on 7/16/15.
 */

import java.util.*;

// Complexity O(nlogn) ---- because of sorting

public class Stringmanip_anagram {

    static boolean anagram(String s1, String s2){

        ArrayList<Character> s1_let= new ArrayList<Character>();
        ArrayList<Character> s2_let= new ArrayList<Character>();


        // Check Length
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1!=l2)
            return false;

        //First String Manipulations

        for(int i=0;i<l1;i++)
        s1_let.add(s1.charAt(i));
        Collections.sort(s1_let, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if((int)o1<(int)o2)
                    return 1;
                else
                return -1;
            }
        });
        System.out.println(s1_let);


        // Second String Manipulations
        for(int i=0;i<l2;i++)
            s2_let.add(s2.charAt(i));
        Collections.sort(s2_let, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if ((int) o1 < (int) o2)
                    return 1;
                else
                    return -1;
            }
        });
        System.out.println(s2_let);

        int count =0;
    for (int i=0;i<l1;i++)
        {
            if(s1_let.get(i)!=s2_let.get(i))
                count++;
        }

        if(count==0)
            return true;

        return false;
    }

    public static void main(String[] args)
    {
        Stringmanip_anagram s = new Stringmanip_anagram();
        if(s.anagram("abcd","dcba"))
            System.out.println("They are anagrams");
        else
            System.out.println("They are not anagrams");


    }

}
