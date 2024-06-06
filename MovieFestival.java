// https://cses.fi/problemset/task/1629/
// 0.59 s

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class FastReader extends PrintWriter{
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() { this(System.in, System.out); }
    public FastReader(InputStream i, OutputStream o) {
        super(o);
        br = new BufferedReader(new InputStreamReader(i));
    }

    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        } catch (Exception e) { }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

public class MovieFestival {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();

        //MIN HEAP
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new ArrayComparator());
        for (int i = 0; i  < n; i++) {
            minHeap.add(new int[]{in.nextInt(), in.nextInt()});
        }

        int movies_watched = 0;
        int last_watched = -1;
        for (int i = 0; i < n; i++) {
            int[] movie = minHeap.poll();
            if (last_watched <= movie[0]) {
                movies_watched++;
                last_watched = movie[1];
            }

        }

        System.out.println(movies_watched);

    }
}

class ArrayComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        // Assuming both arrays have at least two elements
        // Compare the second elements
        return Integer.compare(a[1], b[1]);
    }
}