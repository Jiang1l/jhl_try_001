import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permute {
    public static void main(String[] args) {

       int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }


    }
  static   List<List<Integer>> res = new ArrayList<>();
  static   List<Integer> list = new ArrayList<>();
  static   boolean[] visited;

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        dfs(nums, 0);
        return res;

    }

    private static void dfs(int[] nums, int start) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i-1]) continue;
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, i + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }



}