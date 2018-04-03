package interview.array;

/**
 * @author rajasan
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int l = 0;
        int e = len - 1;

        while (l <= e) {
            int mid = (l + e) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < nums[l] || nums[mid] < nums[e]) {
                if (target > nums[mid] && target <= nums[e]) {
                    l = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else if (nums[mid] > nums[l] || nums[mid] > nums[e]) {
                if (target >= nums[l] && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                l++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 8, 9, 10, 11, 12, 4, 5, 7 };
        int[] arr1 = new int[] { 1, 3, 1, 1, 1 };

        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int i = s.search(arr1, 3);

        System.out.println(arr1[i]);
    }

}
