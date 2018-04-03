package interview.array;

import java.util.Arrays;

/**
 * @author rajasan
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        FindDuplicate f = new FindDuplicate();
        System.out.println(f.findDuplicate(new int[] { 2, 6, 7, 4, 5, 1, 3, 6, 8 }));
    }
}
