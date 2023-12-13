import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;


import static java.lang.Math.max;


public class LengthOfLongestSubstring {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) { int len = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            len = Math.max(len, i - left + 1);
        }
        return len;
    }


    public int climbStairs(int n) {

       if (n < 2) {
           return n;
       }
       if (n == 2) return 2;
       int[] dp = new int[n+1];
       dp[0] = 0;
       dp[1] = 1;
       dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return  dp[n];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];

    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]){
                return i;
            }
        }
        return 0;

    }
}
