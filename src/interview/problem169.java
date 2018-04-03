package interview;

/**
 * @author rajasan
 */
public class problem169 {

    public static int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    max = nums[i];
                    count++;
                }
            }
        }

        return max;
    }

    //    public int majorityElement(int[] nums) {
    //
    //        if (nums == null || nums.length == 0) {
    //            return 0;
    //        }
    //
    //        List<Integer> l = new ArrayList<>(nums.length);
    //
    //        for (int i = 0; i < nums.length; i++) {
    //            l.add(nums[i]);
    //        }
    //
    //        Collections.sort(l);
    //
    //        return l.get(l.size() / 2);
    //    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 1, 1, 2, 1, 3, 3, 1, 1, 3 }));
    }

}
