package interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rajasan
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null || nums.length == 0) {
            new ArrayList<>();
        }

        int[] num = new int[nums.length + 1];

        num[0] = 1;

        for (int i = 0; i < num.length; i++) {
            num[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            num[nums[i]] = 1;
        }

        List<Integer> d = new ArrayList<>();

        for (int i = 1; i < num.length; i++) {
            if (num[i] != 1) {
                d.add(i);
            }
        }

        return d;
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {

        if (nums == null || nums.length == 0) {
            new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (val < nums.length && nums[val] > 0) {
                nums[val] = -(nums[val]);
            }
        }

        List<Integer> d = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                d.add(i + 1);
            }
        }

        return d;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers1(new int[] { 4, 3, 2, 7, 8, 2, 6, 1 }));
    }

}
