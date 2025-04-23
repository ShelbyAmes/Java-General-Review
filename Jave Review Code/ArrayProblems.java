package problems;

/**
 * See the spec on the website for example behavior.
 * REMEMBER THE FOLLOWING RESTRICTIONS:
 * - Do not add any additional imports
 * - Do not create new `int[]` objects for `toString` or `rotateRight`
 */
public class ArrayProblems {

    // input a main so it runs?
    public static void main(String[] args) {
        int[] sampleArray = {7, 3, 8, 19};
        rotateRight(sampleArray);
    }
    /**
     * Returns a `String` representation of the input array.
     * Always starts with '[' and ends with ']'; elements are separated by ',' and a space.
     */
    public static String toString(int[] array) {
        String s = "[";
        for (int i = 0; i < array.length; i++) {
            s = s + array[i];
            if (i < array.length - 1) {
                s = s + ", ";
            }
        }
        s = s + "]";
        return s;
    }

    /**
     * Returns a new array containing the input array's elements in reversed order.
     * Does not modify the input array.
     */
    public static int[] reverse(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - 1 - i] = array[i];
        }
        return reversed;
    }

    /**
     * Rotates the values in the array to the right.
     */
    public static void rotateRight(int[] array) {
        if (array.length != 0) {
            int saved = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = saved;
        }
    }
}
