// https://leetcode.com/problems/valid-triangle-number/submissions/1279910654/
// 189 ms
// 42.92 mb [beats 85.37% of users]

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
//        System.out.println(triangleNumber(new int[]{2,2,3,4}));
//        System.out.println("-----------");
//        System.out.println(triangleNumber(new int[]{2,3,4,4}));

//        System.out.println(triangleNumber(new int[]{2,2,3,4}));
//        System.out.println(triangleNumber(new int[]{1,2,3,5,12}));
//        System.out.println(triangleNumber(new int[]{4,2,3,4}));
        System.out.println(triangleNumber(new int[]{24,3,82,22,35,84,19}));
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int count = 0;

        for (int i = 0; i < nums.length-2; i++) {
            for (int rp = i+1; rp < nums.length-1; rp++) {
                //System.out.println(nums[i] + " " + nums[rp]);

                // find the index of the last possible value that works
                int largestWorkingValIndex = binarySearch(nums, nums[i] + nums[rp]-1, rp+1);

                //System.out.println(largestWorkingValIndex + " works. Adding " + (largestWorkingValIndex-rp) + " to count");
                count += largestWorkingValIndex-rp;
            }
        }


        return count;
    }


    public static int binarySearch(int[] nums, int findVal, int lowerBound) {
        // find the largest index of x that works
        int lo = lowerBound, hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] <= findVal)
                lo = mid + 1;
            if (nums[mid] > findVal)
                hi = mid;
        }

        /** Since we are trying to find the largest index of
         a value <= findVal, we return lo if it's arr element is
         findVal, or otherwise, return the index-1 (the next
         largest value) **/

        if (nums[lo] == findVal) {
            return lo;
        }
        /** 1) {2,2,3,4}, 3, 0
         2) {3,4,5,5}, 6, 0
         last element issue.

         W/o this condition, 1) was index 2 [correct] and 2) was returning index 2 [instead of 3].
         2) happened because the search assumed we found a larger value than 6 (findVal), without a 6 in the array, so it's returning the next largest value (index-1). But, this isn't the case, since it's just because we're at the last element.

         BUT simply adding "(|| lo == nums.length-1)" to the above condition would make
         3) {2,2,3,4}, 3, 0
         return index 3 [instead of 2], since now we assume that being at the last index nullifies the case where the index-1 is actually the correct answer

         So we add (&& nums[lo] < findVal) because we want to return the lo index if the value we are at is less than findVal (since that means that we don't index-1 since we haven't found an value larger than findVal)
         **/
        if (lo == nums.length-1 && nums[lo] < findVal) {
            return lo;
        }

        else {
            return lo - 1;
        }
    }
}
