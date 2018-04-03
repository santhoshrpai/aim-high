package interview.array;

import java.util.Arrays;

import interview.Validate;

/**
 * @author rajasan
 */
public class FindMedian {

    public static double findMedian(int[] arr) {
        if (Validate.validateArray(arr)) {
            return -1;
        }

        Arrays.sort(arr);

        int len = arr.length;

        if (len % 2 == 0) {
            return (arr[len / 2 - 1] + arr[len / 2]) / 2.0;
        } else {
            return arr[len / 2];
        }
    }

    public static double findOptimizedMedian(int[] arr) {

        int index = -1;
        int n = arr.length;

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            index = partition(arr, start, end);
            if (n % 2 == 0 && index == n / 2) {
                return (double) arr[index];
            }
            if (index < n / 2) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }

        return 1.0;
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
        //        System.out.println(findMedian(new int[] { 10, 8, 9, 15, 1, 7 }));
        System.out.println(findOptimizedMedian(new int[] { 1, 2, 3, 4, 5, 6 }));

    }

}
