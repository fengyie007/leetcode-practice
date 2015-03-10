package c004;

/**
 * Created by wenjie.cao on 3/9/15.
 */
public class Solution2 {

    public static void main(String[] args) {
//        int[] a = {};
//        int[] b = {2, 3};
        int[] a = {1,2,3,4};
        int[] b = {5,6,7,8};
        System.out.println(new Solution2().findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        int a[] = A;
        int b[] = B;
        int ia = 0;
        int ib = 0;
        int idx = 0;

        boolean isOdd = len%2 !=0;

        int cur = 0;
        int index = len / 2;
        while (ia < a.length || ib < b.length){
            int old = cur;
            if(a.length == 0){
                return isOdd?b[(index)]:(b[index -1]+b[(index)])/2.0;
            } else if(b.length == 0){
                return isOdd?a[(index)]:(a[index -1]+a[(index)])/2.0;
            } else {
                if(ia < a.length && ib < b.length){
                    if(a[ia] > b[ib]) {
                        cur = b[ib];
                        ib++;
                        idx++;
                    } else {
                        cur = a[ia];
                        ia++;
                        idx++;
                    }
                } else if(ia >= a.length){
                    cur = b[ib];
                    ib ++;
                    idx ++;
                } else {
                    cur = a[ia];
                    ia++;
                    idx++;
                }
                if(idx-1 == index){
                    return isOdd?cur:(old+cur)/2.0;
                }
            }
        }
        return 0;
    }



}