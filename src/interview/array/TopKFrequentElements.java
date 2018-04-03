package interview.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rajasan
 */
public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k > nums.length) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<Integer>[] result = new ArrayList[len + 1];
        for (int i : map.keySet()) {
            int index = map.get(i);
            if (result[index] == null) {
                result[index] = new ArrayList<>();
            }
            result[index].add(i);
        }

        List<Integer> finalResult = new ArrayList<>();

        int c = k;
        for (int i = len; i >= 0; i--) {
            if (c == 0) {
                break;
            }
            if (result[i] == null) {
                continue;
            }
            int s = result[i].size();

            if (s <= c) {
                c -= s;
                finalResult.addAll(result[i]);
            } else {
                for (int j : result[i]) {
                    finalResult.add(j);
                    c--;
                    if (c == 0) {
                        break;
                    }
                }
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        List<Integer> n = topKFrequent(new int[] { 1 }, 1);

        for (int i = 0; i < n.size(); i++) {
            System.out.print(n.get(i) + ",");
        }
    }

}