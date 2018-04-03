package interview.array;

/**
 * @author rajasan
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int l = nums.length - 1;
        for (int i = l; i >= 0; i--) {
            if (i + nums[i] >= l) {
                l = i;
            }
        }

        return l == 0;
    }

}
