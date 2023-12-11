import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combin {
    public static void main(String[] args){
        List<List<Integer>> combine = combine(4, 2);
        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }
    }
    static List<List<Integer>> res = new ArrayList<>();
    static    List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    private  static void dfs(int n, int k, int cur) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i <= n; i++) {

            list.add(i);
            dfs(n, k, i + 1);
            list.remove(list.size() - 1);

        }
    }

}
