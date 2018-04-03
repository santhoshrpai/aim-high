package interview.array;

import java.util.PriorityQueue;

/**
 * @author rajasan
 */
public class KthSmallestInMatrix {

    public static int kthSmallest(int[][] matrix, int k) {

        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        if (matrix[0].length == 0) {
            return -1;
        }

        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;

            high = low - 1;

            System.out.println(mid);

            int j = -1, g = matrix[0].length;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0) {
                    if (mid < matrix[i][j]) {

                    }
                }
            }

        }

        System.out.println(low + "::" + high);

        return 0;

    }

    public static int kthSmallestUsingHeap(int[][] matrix, int k) {

        PriorityQueue<Tuple> pq = new PriorityQueue<>(k, (o1, o2) -> o1.val - o2.val);

        int n = matrix.length;

        for (int j = 0; j <= n - 1; j++)
            pq.offer(new Tuple(0, j, matrix[0][j]));
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1)
                continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;

    }

    static class Tuple {

        int x, y, val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static int kthSmallest1(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid)
                    j--;
                count += (j + 1);
            }
            if (count < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 5, 9 }, { 7, 8, 13 }, { 12, 13, 15 } };
        System.out.println(kthSmallestUsingHeap(m, 5));
    }
}