package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author rajasan
 */
public class problem239 {

    public static void main(String[] args) {
        int[] n = { -7, -8, 7, 5, 7, 1, 6, 0 };

        int[] res = maxSlidingWindow(n, 4);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length <= 0 || k > nums.length || k <= 0) {
            int[] n = new int[0];
            return n;
        }

        TreeSet<Integer> tree = new TreeSet<>();

        int j = 0;
        int l = -1;

        List<Integer> inte = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (l == k - 1) {
                inte.add(tree.last());
                tree.remove(nums[j++]);
                l--;
            }
            l++;
            tree.add(nums[i]);
        }

        inte.add(tree.last());

        int[] n = new int[inte.size()];

        for (int i = 0; i < inte.size(); i++) {
            n[i] = inte.get(i);
        }

        return n;

    }
}
