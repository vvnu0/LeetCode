// https://leetcode.com/problems/container-with-most-water/
// 4 ms [beats 87.33%]
// 56.82 mb [Beats 93.38%]

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
        System.out.println(maxArea(new int[]{1,2,4,3}));
        System.out.println(maxArea(new int[]{2,3,4,5,18,17,6})); // out 16, expect 17

        // [1,2, 4,3]
    }

    public static int maxArea(int[] height) {
        int lp = 0, rp = height.length-1;

        int maxArea = 0;
        while (lp < rp) {
            maxArea = Math.max(Math.min(height[lp], height[rp])*(rp-lp), maxArea);

            if (height[lp] > height[rp]) rp--;
            else lp++;

        }

        return maxArea;
    }
}
