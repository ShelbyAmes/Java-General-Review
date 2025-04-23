package problems;

import datastructures.LinkedIntList;
// Checkstyle will complain that this is an unused import until you use it in your code.
import datastructures.LinkedIntList.ListNode;

/**
 * See the spec on the website for example behavior.
 * REMEMBER THE FOLLOWING RESTRICTIONS:
 * - do not call any methods on the `LinkedIntList` objects.
 * - do not construct new `ListNode` objects for `reverse3` or `firstToLast`
 *      (though you may have as many `ListNode` variables as you like).
 * - do not construct any external data structures such as arrays, queues, lists, etc.
 * - do not mutate the `data` field of any node; instead, change the list only by modifying
 *      links between nodes.
 */

public class LinkedIntListProblems {

    /**
     * Reverses the 3 elements in the `LinkedIntList` (assume there are exactly 3 elements).
     */
    public static void reverse3(LinkedIntList list) {
        ListNode curr = list.front;
        ListNode curr2 = curr.next;
        ListNode curr3 = curr.next.next;
        curr3.next = curr2;
        curr2.next = curr;
        curr.next = null;
        list.front = curr3;
    }

    /**
     * Moves the first element of the input list to the back of the list.
     */
    public static void firstToLast(LinkedIntList list) {
        if (list.front != null) {
            ListNode curr = list.front;
            ListNode first = curr;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = first;
            list.front = first.next;
            first.next = null;
        }
    }

    /**
     * Returns a list consisting of the integers of a followed by the integers
     * of n. Does not modify items of A or B.
     */
    public static LinkedIntList concatenate(LinkedIntList a, LinkedIntList b) {
        LinkedIntList newList = new LinkedIntList();
        if (a.front != null) {
            newList.front = new ListNode(a.front.data);
            ListNode curr = a.front;
            ListNode add = b.front;
            ListNode newNode = newList.front;
            while (curr.next != null) {
                newNode.next = new ListNode(curr.next.data);
                curr = curr.next;
                newNode = newNode.next;
            }
            while (add != null) {
                newNode.next = new ListNode(add.data);
                add = add.next;
                newNode = newNode.next;
            }
            return newList;
        }
        return b;
    }
}
