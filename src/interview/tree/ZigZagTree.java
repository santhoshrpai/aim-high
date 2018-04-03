package interview.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rajasan
 */
public class ZigZagTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();

        int set = 1;

        List<List<Integer>> l = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> l1 = new ArrayList<>();
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode x = q.poll();

                if (set < 0) {
                    l1.add(0, x.val);
                } else {
                    l1.add(x.val);
                }

                if (x.left != null) {
                    q.add(x.left);
                }
                if (x.right != null) {
                    q.add(x.right);
                }
            }
            l.add(l1);
            set = set * -1;
        }

        return l;

    }

}
