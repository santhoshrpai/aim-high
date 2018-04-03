package interview.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rajasan
 */
public class LevelOrderByLevel {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);

        List<List<Integer>> p = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<Integer> x = new ArrayList<>();
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                x.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            p.add(x);
        }

        return p;
    }

}
