/**
 * Created by Bharath on 8/23/15.
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class AllSubsetsOfSet {

    public static void main(String[] args) {
        final List<List<String>> allSubsets = powerSet(Arrays.asList(1, 2, 3, 4), 0);
        for (List<String> subsets : allSubsets) {
            System.out.println(subsets);
        }
    }

    private static List<List<String>> powerSet(final List<Integer> values,
                                               int index) {
        if (index == values.size()) {
            return new ArrayList<>();
        }
        int val = values.get(index);
        List<List<String>> subset = powerSet(values, index + 1);
        List<List<String>> returnList = new ArrayList<>();
        returnList.add(Arrays.asList(String.valueOf(val)));
        returnList.addAll(subset);
        for (final List<String> subsetValues : subset) {
            for (final String subsetValue : subsetValues) {
                returnList.add(Arrays.asList(val + "," + subsetValue));
            }
        }
        return returnList;
    }
}