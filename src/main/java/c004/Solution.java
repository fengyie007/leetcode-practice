package c004;

import java.util.Arrays;

/**
 * Created by wenjie.cao on 3/9/15.
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {2,3};
//        int[] a = {1,2,3};
//        int[] b = {5,6,7,8};
        System.out.println(new Solution().findMedianSortedArrays(a,b));
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int[] c = new int[A.length + B.length];
        System.arraycopy(A, 0, c, 0, A.length);
        System.arraycopy(B, 0, c, A.length, B.length);

        Arrays.sort(c);

        if(c.length % 2 == 0){
            return (c[c.length/2-1]+c[c.length/2])/2.0;
        } else {
            return c[c.length/2];
        }
    }
}