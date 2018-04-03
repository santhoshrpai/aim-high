package interview.array;

import interview.Validate;

/**
 * @author rajasan
 */
public class QuickSort {

    public void quickSort(int[] arr, int start, int end) {
        if (Validate.validateArray(arr)) {
            return;
        }

        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    public int partition(int[] arr, int start, int end) {

        //        if (!(start <= end && end < arr.length)) {
        //            return -1;
        //        }

        int pivotElement = arr[end];
        int index = start;

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivotElement) {
                swap(arr, i, index++);
            }
        }
        swap(arr, index, end);
        return index;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 4, 3, 2, 7, 8, 5, 6, 1 };
        QuickSort q = new QuickSort();
        q.quickSort(arr, 0, arr.length - 1);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }

}
