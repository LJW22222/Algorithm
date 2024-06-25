
import java.io.*;
import java.nio.Buffer;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer((in.readLine()));
            int B = Integer.parseInt(st.nextToken());
            int C = 0;
            if (st.hasMoreTokens()) {
                C = Integer.parseInt(st.nextToken());
            }
            if (B == 1) {
                stack.add(C);
            } else if (B == 2) {
                if (stack.isEmpty()) {
                    out.write("-1\n");
                } else {
                    out.write(stack.pop()+"\n");
                }
            } else if (B == 3) {
                out.write(stack.size()+"\n");
            } else if (B == 4) {
                if (stack.isEmpty()) {
                    out.write("1\n");
                } else {
                    out.write("0\n");
                }
            } else {
                if (stack.isEmpty()) {
                    out.write("-1\n");
                } else {
                    out.write(stack.peek()+"\n");
                }
            }
        }
        out.flush();
        out.close();
    }
}
