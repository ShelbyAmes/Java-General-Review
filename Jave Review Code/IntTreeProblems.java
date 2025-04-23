package problems;

import datastructures.IntTree;
// Checkstyle will complain that this is an unused import until you use it in your code.
import datastructures.IntTree.IntTreeNode;

/**
 * See the spec on the website for tips and example behavior.

 * Also note: you may want to use private helper methods to help you solve these problems.
 * YOU MUST MAKE THE PRIVATE HELPER METHODS STATIC, or else your code will not compile.
 * This happens for reasons that aren't the focus of this assignment and are mostly skimmed over in
 * 142 and 143. If you want to know more, you can ask on the discussion board or at office hours.

 * REMEMBER THE FOLLOWING RESTRICTIONS:
 * - do not call any methods on the `IntTree` objects
 * - do not construct new `IntTreeNode` objects (though you may have as many `IntTreeNode` variables
 *      as you like).
 * - do not construct any external data structures such as arrays, queues, lists, etc.
 * - do not mutate the `data` field of any node; instead, change the tree only by modifying
 *      links between nodes.
 */

public class IntTreeProblems {

    /**
     * Computes and returns the sum of the values multiplied by their depths in the given tree.
     * (The root node is treated as having depth 1.)
     */
    public static int depthSum(IntTree tree) {
        return helperDepth(tree.overallRoot, 1);
    }

    private static int helperDepth(IntTreeNode root, int node) {
        if (root == null) {
            return 0;
        } else {
            int sum = root.data * node;
            int right = helperDepth(root.right, node + 1);
            int left = helperDepth(root.left, node + 1);
            return sum + right + left;
        }
    }

    /**
     * Removes all leaf nodes from the given tree.
     */
    public static void removeLeaves(IntTree tree) {
        tree.overallRoot = helperRemove(tree.overallRoot);
    }

    private static IntTreeNode helperRemove(IntTreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = helperRemove(root.left);
        root.right = helperRemove(root.right);
        return root;
    }

    /**
     * Removes from the given BST all values less than `min` or greater than `max`.
     * (The resulting tree is still a BST.)
     */
    public static void trim(IntTree tree, int min, int max) {
        tree.overallRoot = helperTrim(tree.overallRoot, min, max);

    }

    private static IntTreeNode helperTrim(IntTreeNode root, int min, int max) {
        if (root == null) {
            return null;
        }
        if (root.data < min) {
            return helperTrim(root.right, min, max);
        }
        if (root.data > max) {
            return helperTrim(root.left, min, max);
        }
        root.left = helperTrim(root.left, min, max);
        root.right = helperTrim(root.right, min, max);
        return root;
    }
}
