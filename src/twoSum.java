import java.util.HashMap;
import java.util.Map;


public class twoSum {
    // 时间复杂度n2，空间负责度O（1）
    public static int[] sum1(int[] nums, int target){

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }


    public static int[] sum2(int[] nums, int target){
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(hashtable.containsKey(target - nums[i])){
                return new int[]{i,hashtable.get(target-nums[i])};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }
}

