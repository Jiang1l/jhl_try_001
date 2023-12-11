public class TwoList {

    public  int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int x = 0,y=0,cur=0;
        int n1 = nums1.length,n2 = nums2.length;
        int[] res = new int[n1 + n2];
        while (x < nums1.length && y < nums2.length){
            if(nums1[x] > nums2[y]){
                res[cur++] = nums1[x++];
            }else {
                res[cur++] = nums2[y++];
            }
        }
            while (x < n1){
                res[cur++] = nums1[x++];
            }
            while (y < n2){
                res[cur++] = nums2[y++];
        }
            return res;
    }
}
