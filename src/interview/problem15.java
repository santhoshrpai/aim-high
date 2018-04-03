package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rajasan
 */
public class problem15 {

    public static List<List<Integer>> threeSum1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                continue;
            }

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> l1 = new ArrayList<>();
                    l1.add(nums[i]);
                    l1.add(nums[j]);
                    l1.add(nums[k]);
                    l.add(l1);

                    while (k > 0 && nums[k - 1] == nums[k--]) {
                        //                        k--;
                    }
                    while (j < nums.length - 1 && nums[j + 1] == nums[j++]) {
                        //                        j++;
                    }

                } else if (sum > 0) {
                    while (k > 0 && nums[k - 1] == nums[k--]) {
                        //                        k--;
                    }
                } else {
                    while (j < nums.length - 1 && nums[j + 1] == nums[j++]) {
                        //                        j++;
                    }
                }
            }
        }

        return l;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> l1 = new ArrayList<>();
                    l1.add(nums[i]);
                    l1.add(nums[j]);
                    l1.add(nums[k]);
                    l.add(l1);
                    break;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return l;
    }

    public static void main(String[] args) {
        //        System.out.println(threeSum1(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(threeSum1(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }));
    }

}
