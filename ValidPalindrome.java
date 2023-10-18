// Runtime 6 ms
// Memory 43.7 MB

// https://leetcode.com/problems/valid-palindrome/submissions/
// Easy


import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length() - 1;

        int startIndex = 0;
        int endIndex = len;

        Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'b','c','d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));

        while (startIndex < endIndex) {
            if (!set.contains(s.charAt(startIndex))) {
                startIndex++;
                continue;
            }
            if (!set.contains(s.charAt(endIndex))) {
                endIndex--;
                continue;
            }

            char startChar = Character.toLowerCase(s.charAt(startIndex));
            char endChar = Character.toLowerCase(s.charAt(endIndex));

            if (startChar != endChar) return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }
}