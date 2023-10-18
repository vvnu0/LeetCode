// Runtime: 9 ms        [Beats 88.96%of users with Java]
// Memory:  44.16 MB    [Beats 48.35%of users with Java]

// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/submissions/?envType=daily-question&envId=2023-10-02
// Medium

class Solution {
    public boolean winnerOfGame(String colors) {
        
        char prev = colors.charAt(0);
        int A = 0;
        int B = 0;
        int count = 1;

        for (int i = 1; i < colors.length(); i++) {
            if (prev == colors.charAt(i)) {
                count++;
                continue;
            }

            else if (prev == 'A') {
                if (count > 2) A += (count-2);
                prev = 'B';
            }
            else {
                if (count > 2) B += (count-2);
                prev = 'A';
            }
            count = 1;
        }

        if (count < 2);
        else if (prev == 'A') A += (count-2);
        else B += (count-2);

        if (A > B) return true;
        return false;

    }
}
