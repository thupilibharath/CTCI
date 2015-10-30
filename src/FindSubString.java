/**
 * Created by Bharath on 8/20/15.
 */

// IMPORTANT LOGIC

public class FindSubString {
    boolean findSub(String search, String input ) {
        if ((search == null) | (input == null)) {
            System.out.println("Input 2 valid strings");
        }

        int m = search.length();
        int n = input.length();
        boolean match_not_found = false;
        for (int i = 0; i <= (m - n); i++) {
            match_not_found = false;
            for (int j = 0; j < n; j++) {
                if (search.charAt(i + j) != input.charAt(j)) {
                    match_not_found = true;
                    break;
                }
            }
            if (!match_not_found)
                return match_not_found;
        }
        return match_not_found;
    }

    public static void main(String[] args) {
        FindSubString f1 = new FindSubString();
        if (!f1.findSub("battep", "tep"))
            System.out.println("Substring found");
        else
            System.out.println("Substring not found");
    }
}
