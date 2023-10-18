// Runtime:   0 ms     [Beats 100.00% of users with Java]
// Memory:    43.27 MB [Beats 94.41%of users with Java]

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
// Medium

class Solution {
    public int removeDuplicates(int[] nums) {
        int oldStart = 0;
        int newStart = 0;

        int prev = Integer.MIN_VALUE;
        int count = 0;

        for (; oldStart < nums.length; oldStart++) {
            if (nums[oldStart] != prev) {
                nums[newStart] = nums[oldStart];
                prev = nums[oldStart];

                newStart++;
                count = 0;
            }
            else if (count == 0){
                nums[newStart] = nums[oldStart];
                count++;
                newStart++;
            }
            
        }
        return (newStart);
    }
}
