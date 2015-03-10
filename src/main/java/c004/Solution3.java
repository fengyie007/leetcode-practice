package c004;

/**
 * Created by wenjie.cao on 3/9/15.
 */
public class Solution3 {

    public static void main(String[] args) {
//        int[] a = {};
//        int[] b = {2, 3};
        int[] a = {1, 2, 3,4};
        int[] b = {5, 6, 7, 8};
        System.out.println(new Solution3().findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;

        if (total % 2 != 0) {
            return findKth(A, A.length, B, B.length, total / 2 + 1);
        } else {
            return (findKth(A, A.length, B, B.length, total / 2) + findKth(A, A.length, B, B.length, total / 2 + 1)) / 2.0;
        }
    }

    public int findKth(int a[], int m, int b[], int n, int k) {
        if (m > n) {
            return findKth(b, n, a, m, k);
        }
        if (m == 0) {
            return b[k - 1];
        }
        if (k == 1) {
            return Math.min(a[0], b[0]);
        }
        int ia = Math.min(k / 2, m), ib = k - ia;
        if (a[ia - 1] < b[ib - 1]) {
            return findKth(sub(a, ia), m - ia, b, n, k - ia);
        } else if (a[ia - 1] > b[ib - 1]) {
            return findKth(a, m, sub(b, ib), n - ib, k - ib);
        } else {
            return a[ia - 1];
        }
    }

    public int[] sub(int a[], int len) {
        int res[] = new int[a.length - len];
        System.arraycopy(a, len, res, 0, res.length);
        return res;
    }
}