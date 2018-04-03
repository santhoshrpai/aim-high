package interview.array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author rajasan
 */
public class KthLargestInAnArray {

    public static int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (k <= 0 || k > nums.length) {
            return -1;
        }

        Queue<Integer> q = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            q.poll();
        }

        return q.poll();
    }

    public static int findKthLargest(int[] arr, int start, int end, int k) {

        if (start == end) {
            return arr[start];
        }

        int index;
        int n;

        index = partition(arr, start, end);

        n = end - index + 1;
        if (n == k) {
            n = arr[index];
        }
        if (n > k) {
            return findKthLargest(arr, index + 1, end, k);
        } else {
            return findKthLargest(arr, start, index - 1, k - n);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pIndex = end;

        for (int i = end; i >= start; i--) {
            if (arr[i] > pivot) {
                swap(arr, i, pIndex--);
            }
        }

        swap(arr, pIndex, start);

        return pIndex;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 5;
        System.out.println(findKthLargest(nums, k));

        System.out.println(findKthLargest(nums, 0, nums.length - 1, k));

    }
}
