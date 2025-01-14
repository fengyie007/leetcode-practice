/**
 * https://leetcode.cn/problems/maximum-subarray
 */
public class E53 {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     *
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     *  示例 2：
     * 输入：nums = [1]
     * 输出：1
     *
     *  示例 3：
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int solution = maxSubArray(nums);
        System.out.println(solution);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static final int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum > 0){
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
