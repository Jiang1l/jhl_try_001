import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

    }
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
     * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * @param nums 数组
     * @return 三元组
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])continue;
            int x = nums[i];
            int left = i+1,right = nums.length-1;
            while (left < right){
                int sum = x + nums[left] + nums[right];
                if(sum ==0){
                    Collections.addAll(list,x,nums[left],nums[right]);
                    res.add(list);
                    list = new ArrayList<>();
                    int l = nums[left];
                    while (left < right && nums[left] == l){
                        left++;
                    }
                    int r = nums[right];
                    while (right > left && nums[right] == r){
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
return res;
    }

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * @param nums 数组
     * @param target 目标
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 999999;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if(i > 0 && nums[i-1] == nums[i])continue;;
            int left = i + 1, right = n-1;

            while (left < right){
             int sum = x + nums[left] + nums[right];
             res = Math.abs(sum - target) < Math.abs(res - target) ? sum : res;
             if(sum > target){
                 right --;
             }else if (sum < target){
                 left ++;
             }else return target;

            }
        }
return res;
    }
}
