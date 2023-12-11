public class MaxProfit {
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,6,4};
        System.out.println(maxProfit(nums));
    }
    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * @param prices 第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格
     * @return 返回你可以从这笔交易中获取的最大利润
     */
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0],res = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min,prices[i-1]);
            res = Math.max(res,prices[i] - min);
        }
        return res;
    }

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * @param prices  prices[i] 表示某支股票第 i 天的价格
     * @return 返回 你能获得的 最大 利润
     */
    public static int maxProfitTwo(int[] prices){
       if( prices == null ||prices.length < 2 )return 0;
       int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);

        }
        return dp[n-1][0];
    /*    if (arr == null || arr.length <= 1) return 0;

        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {  // 卖出有利可图
                ans += (arr[i] - arr[i-1]);
            }
        }

        return ans;*/
    }
}
