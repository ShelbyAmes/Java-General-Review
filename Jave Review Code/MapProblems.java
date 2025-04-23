package problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * See the spec on the website for example behavior.
 */
public class MapProblems {

    /**
     * Returns true if any string appears at least 3 times in the given list; false otherwise.
     */
    public static boolean contains3(List<String> list) {
        // go through and count the number of specific strings
        // do this by collecting the first String, checking each value in list; increasing count++
        // then repeat for next string.
        // associate a value of appearence with a map
        // then go through map and see if any value is greater than 3
        Map<String, Integer> coll = new HashMap<>();
        for (String s : list) {
            if (coll.containsKey(s)) {
                coll.put(s, coll.get(s) + 1);
            } else {
                coll.put(s, 1);
            }
            if (coll.get(s) >= 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a map containing the intersection of the two input maps.
     * A key-value pair exists in the output iff the same key-value pair exists in both input maps.
     */
    public static Map<String, Integer> intersect(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> result = new HashMap<>();
        for (String key : m1.keySet()) {
            if (m2.containsKey(key) && m1.get(key).equals(m2.get(key))) {
                result.put(key, m1.get(key));
            }
        }
        return result;
    }
}
