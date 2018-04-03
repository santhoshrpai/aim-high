package interview.array;

import java.util.Arrays;

/**
 * @author rajasan
 */
public class RemoveDuplicatesInPlace {

    public static int[] removeDuplicates4(int[] nums) {

        if (nums == null) {
            return new int[] { 0 };
        }

        Arrays.sort(nums);

        int j = 0;
        int count = 0;
        int dupCount = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[j] == nums[i]) {
                dupCount++;
                continue;
            }
            count++;
            int k = i;
            if (j != i - 1) {
                while (k < len && j < len) {
                    nums[++j] = nums[k++];
                }
                j = count;
                i = count;
            } else {
                j++;
            }
            len = nums.length - dupCount + 1;
        }
        return nums;
    }

    public static int[] removeDuplicates(int[] nums) {

        if (nums == null) {
            return new int[] { 0 };
        }

        Arrays.sort(nums);

        int j = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return nums;
    }

    public static int removeDuplicates1(int[] nums) {

        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        int j = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[j] == nums[i]) {
                continue;
            }
            j = i;
            count++;
        }
        return count + 1;
    }

    static int[] removeDuplicates2(int arr[]) {
        if (arr == null)
            return new int[] { 0 };

        int n = arr.length;
        Arrays.sort(arr);

        // To store index of next unique element
        int j = 0;

        // Doing same as done in Method 1
        // Just maintaining another updated index i.e. j
        for (int i = 0; i < n - 1; i++)
            if (arr[i] != arr[i + 1])
                arr[j++] = arr[i];

        arr[j++] = arr[n - 1];

        return arr;
    }

    public static void main(String[] args) {
        int[] n = removeDuplicates(new int[] { 1, 1, 1, 1, 1 });

        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + ",");
        }

        System.out.println();
        n = removeDuplicates(new int[] { 1, 1, 1, 1, 1, 2, 3, 4, 4, 4, 4 });

        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + ",");
        }
    }
}
