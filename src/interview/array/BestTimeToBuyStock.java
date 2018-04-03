package interview.array;

/**
 * @author rajasan
 */
public class BestTimeToBuyStock {

    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxSoFar = 0;
        int minSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            maxSoFar = Math.max(maxSoFar, prices[i] - minSoFar);
        }

        return maxSoFar;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

}
