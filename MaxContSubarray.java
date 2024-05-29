// https://leetcode.com/problems/maximum-subarray/
// 5/28

public class MaxContSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1}));

    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i< nums.length; i++) {
           sum = Math.max(sum+nums[i], nums[i]);
           max = Math.max(sum, max);
        }
        return max;
    }
}
