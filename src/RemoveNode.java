import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveNode {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
        List<List<Integer>> lists = combinationSum(nums, 7);
        for (List<Integer> integers : lists) {
            System.out.println(integers);
        }
    }
    public  static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head,slow = head,pre = head;
        for (int i = 0; i < n; i++) {
            if(fast.next != null) fast = fast.next;
        }
        while (fast.next!= null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre;
    }

    /**
     * 合成两个有序链表
     * @param list1 链表1
     * @param list2 链表2
     * @return 有序链表头节点
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(0,null);
        ListNode res = pre;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                pre.next = list1;
                list1 = list1.next;
            }else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 != null)pre.next = list1;
        if (list2 != null)pre.next = list2;
     return res.next;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * @param nums 数组
     * @param val 数值等于 val
     * @return 移除后数组的新长度
     */
    public int removeElement2(int[] nums, int val) {
        int current = 0;
        int right = nums.length - 1;
        while (current <= right) {
            if (nums[current] == val) {
                swap(nums, current, right--);
            } else {
                current++;
            }
        }
        return current;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
              continue;
            }
            nums[count++]=nums[i];
        }

        return count;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
     * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * @param candidates 数组
     * @param target 目标和
     * @return 集合
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }

    private static void dfs(int[] candidates, int start, int target) {
        if (target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1])continue;
            target -= candidates[i];
            list.add(candidates[i]);
            dfs(candidates,i,target);
            target +=candidates[i];
            list.removeLast();
        }
    }

    private static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return false;
        ListNode slow = head,fast = head.next.next;
        while (fast!= null && fast.next != null){
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;

    }
    // 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return null;
        ListNode slow = head,fast = head.next.next;
        while (fast!= null && fast.next != null){
            if (slow == fast) {
                while (slow!=head){
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;

    }
}


