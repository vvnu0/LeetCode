// https://leetcode.com/problems/plus-one/description/

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{8,8,5,0,5,1,9,7})));
    }

    public static int[] plusOne(int[] digits) {
        // start from the last place digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // if the digit is 9, make it 0 and continue w/ carry over; otherwise, add 1
            digits[i] = digits[i] == 9 ? 0 : digits[i] + 1;
            if (digits[i] != 0) break;
        }
        // If the leading digit is 0, make a new array with 1 i.e. 999 --> 1000
        if (digits[0] == 0) {
            digits = new int [digits.length+1];
            digits[0] = 1;
        }

        return digits;
    }
}
