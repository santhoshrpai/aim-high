package interview.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author rajasan
 */
public class IterativeInOrder {

    public List<Integer> rinorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> l = new ArrayList<>();

        List<Integer> left = rinorderTraversal(root.left);
        List<Integer> right = rinorderTraversal(root.right);

        l.addAll(left);
        l.add(root.val);
        l.addAll(right);

        return l;
    }

    public List<Integer> itinorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();

        TreeNode t = root;

        while (t != null || !s.isEmpty()) {
            while (t != null) {
                s.push(t);
                t = t.left;
            }

            l.add(s.pop().val);

            t = t.right;
        }

        return l;
    }

}
