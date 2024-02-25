import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int[] L = new int[A];
        int[] N = new int[A];
        Stack<Integer> stacklist = new Stack<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < A; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        for (int z = 0; z < A; z++) {
            while (!stacklist.isEmpty() && L[stacklist.peek()] < L[z]) {
                N[stacklist.pop()] = L[z];
            }
            stacklist.push(z);
        }


        while (!stacklist.isEmpty()) {
            int z = stacklist.pop();
            N[z] = -1;
        }

        for (int z = 0; z < A; z++) {
            out.write(N[z] + " ");
        }
        out.flush();
        out.close();
    }
}
