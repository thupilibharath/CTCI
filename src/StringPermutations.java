/**
 * Created by Bharath on 10/7/15.
 */
public class StringPermutations {


    void getPermutations(char[] s, int l, int r) {
        if (l == r)
            System.out.println(s);
        else
            for (int i = l; i <= r; i++) {
                char temp = s[l];
                s[l] = s[i];
                s[i] = temp;

                getPermutations(s, l + 1, r);

                temp = s[l];
                s[l] = s[i];
                s[i] = temp;

            }
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c'};
        StringPermutations s1 = new StringPermutations();
        s1.getPermutations(a, 0, 2);
        System.out.println((int)('a'));
    }
}
