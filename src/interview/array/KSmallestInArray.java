package interview.array;

import java.util.Arrays;

/**
 * @author rajasan
 */
public class KSmallestInArray {

    public static int findKthSmallest(int[] arr, int start, int end, int k) {

        if (k > end) {
            return -1;
        }
        if (start == end) {
            return arr[start];
        }

        int index;
        int n;

        index = partition(arr, start, end);

        n = index - start + 1;
        if (n == k) {
            n = arr[index];
        }
        if (n < k) {
            return findKthSmallest(arr, index + 1, end, k - n);
        } else {
            return findKthSmallest(arr, start, index - 1, k);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pIndex++);
            }
        }

        swap(arr, pIndex, end);

        return pIndex;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 8, 9, 15, 1, 7 };
        int k = 11;
        System.out.println(findKthSmallest(arr, 0, arr.length - 1, k));

        Arrays.sort(arr);

        System.out.println(arr[k - 1]);
    }

}
