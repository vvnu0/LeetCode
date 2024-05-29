import java.util.*;

public class MinWindowSubstring {
    public static void main(String[] args) {
        System.out.println(shortestStringLength("adobecodebanc", "abc"));
        System.out.println(shortestStringLength("aaat", "t"));
        // String s is of length n
        // String n is of length m
    }


    public static String shortestStringLength(String s, String l) {
        // Data collection
        LinkedList<int[]> arr = new LinkedList<>();
        HashMap<Integer, Integer> contains = new HashMap<>();
        int shortest = s.length();
        String smallest = s;
        int full = 0;

        // O(m)
        HashSet<Integer> letters = new HashSet<>();
        for (int i = 0; i < l.length(); i++) {
            letters.add((int) l.charAt(i));
        }

        // Code
        // O(n)
        for (int i = 0; i < s.length(); i++) {
            int letter = s.charAt(i);

            // If we see a "window" letter
            if (letters.contains(letter)) {

                // Add in letter, if it's part of window set
                arr.add(new int[]{letter, i});
                if (contains.get(letter) == null || contains.get(letter) == 0) {
                    contains.put(letter, 1);
                    full++;
                }
                else {
                    contains.put(letter, contains.get(letter)+1);
                }

                // Shorten substring window while there exists duplicates of the first element
                // O(>n)
                Integer fl_in_sub = arr.get(0)[0];
                while (contains.get(fl_in_sub) > 1){
                    arr.poll();
                    contains.put(fl_in_sub, contains.get(fl_in_sub)-1);

                    fl_in_sub = arr.get(0)[0];
                }


                // if all three letters exist, check shortest length
                if (full >= letters.size()) {
                    int fl = arr.get(0)[1];
                    int ll = arr.get(arr.size()-1)[1];
//                    System.out.println("Index of first letter: " + arr.get(0)[1]);
//                    System.out.println("Index of last letter: " + arr.get(arr.size()-1)[1]);
                    int length = ll - fl + 1;
                    if (shortest > length) {
                        shortest = length;
                        smallest = s.substring(fl, ll+1);
//                        System.out.println("new shortest: " + shortest);
                    }
                }



            }

        }

        return smallest;
    }
}
