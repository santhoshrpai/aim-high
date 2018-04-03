package interview.array;

/**
 * @author rajasan
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[] { 1, 9, 0, 3, 3, 3, 0, 0, 3, 12 });

    }

}
