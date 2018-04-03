package interview.array;

/**
 * @author rajasan
 */
public class MinimumInARotatedSortedArray {

    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0;
        int e = nums.length - 1;

        while (l < e) {
            int mid = (l + e) / 2;
            if (nums[e] < nums[mid]) {
                l = mid + 1;
            } else {
                e = mid;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 9, 10, 11, 12, 4, 5, 6 };
        int[] arr1 = new int[] { 1, 3, 5 };

        MinimumInARotatedSortedArray s = new MinimumInARotatedSortedArray();
        int i = s.findMin(arr);

        System.out.println(arr[i]);
    }
}
