package interview.tree;

/**
 * @author rajasan
 */
public class FindKthLargestAndSmallestBST {

    private static int k = 0;
    private static int count = 0;

    public static int findKthSmallest(BinaryTreeNode treeNode, int k1) {
        if (treeNode == null) {
            return -1;
        }

        k = k1;

        findKthSmallestUtil(treeNode);

        return count;
    }

    public static void findKthSmallestUtil(BinaryTreeNode treeNode) {

        if (treeNode.left != null) {
            findKthSmallestUtil(treeNode.left);
        }

        k--;

        if (k == 0) {
            count = treeNode.value;
            return;
        }

        if (treeNode.right != null) {
            findKthSmallestUtil(treeNode.right);
        }
    }

    public static int findKthLargest(BinaryTreeNode treeNode, int k1) {
        if (treeNode == null) {
            return -1;
        }

        k = k1;
        count = -1;

        findKthLargesttUtil(treeNode);

        return count;
    }

    public static void findKthLargesttUtil(BinaryTreeNode treeNode) {

        if (treeNode.right != null) {
            findKthSmallestUtil(treeNode.right);
        }

        k--;

        if (k == 0) {
            count = treeNode.value;
            return;
        }

        if (treeNode.left != null) {
            findKthSmallestUtil(treeNode.left);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode child1 = new BinaryTreeNode(5);
        child1.left = new BinaryTreeNode(4);
        child1.right = new BinaryTreeNode(6);

        BinaryTreeNode leftChild = new BinaryTreeNode(11);
        leftChild.left = child1;
        leftChild.right = new BinaryTreeNode(14);

        BinaryTreeNode rightChild = new BinaryTreeNode(23);
        rightChild.left = new BinaryTreeNode(21);
        rightChild.right = new BinaryTreeNode(28);

        BinaryTreeNode t = new BinaryTreeNode(12);
        t.left = leftChild;
        t.right = rightChild;

        System.out.println(findKthSmallest(t, 4));
        System.out.println(findKthLargest(t, 2));

    }

    //                    12
    //            11                     23
    //       5         14         21            28
    //  4         6

}
