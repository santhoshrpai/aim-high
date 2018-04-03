package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rajasan
 */
public class problem1 {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] n = { 3, 2, 4 };
        int[] b = twoSum(n, 6);
        System.out.println(b[0] + ":" + b[1]);
    }
}
