// Runtime:   0ms      [Beats 100% of users in Java]
// Memory:    39.05 MB [Beats 51.72% of users in Java]

// https://leetcode.com/problems/integer-break/description/?envType=daily-question&envId=2023-10-06
// Medium

class Solution {
    public int integerBreak(int n) {
        switch (n){
            case 2: return 1;
            case 3: return 2;
            case 4: return 4;
        }

        int num3 = n/3;
        if ((n-num3*3) == 1) return ((int)Math.pow(3, (num3-1))*4);
        //3^(num3-1)*(4)

        if (n-num3*3 == 0) return ((int)Math.pow(3,num3));
        return ((int)Math.pow(3,num3)*(n-num3*3));
        // (3^(num3)*(n-num3*3))

    }
}
