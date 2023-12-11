import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Jump {
    public static void main(String[] args) {
       /* int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
*/
        LinkedList<Integer> linkedList = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i +1);
            System.out.println(stack);
        }
        System.out.println(stack.pop());

    }

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * 0 <= j <= nums[i] i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数
     * @param nums 数组
     * @return 最小次数
     */
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length]; // 到达位置i所用的最小步数
        Arrays.fill(dp, dp.length - 1);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length && j <= i + nums[i]; j++) { // 从 i 都能 1 步到达的位置
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        return dp[dp.length - 1];
    }
}
