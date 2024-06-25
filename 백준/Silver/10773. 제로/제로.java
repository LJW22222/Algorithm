import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        Stack<Integer> queue = new Stack<>();
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(in.readLine());
            int C = Integer.parseInt(st.nextToken());
            if (C == 0) {
                queue.pop();
            } else {
                queue.add(C);
            }
        }
        int sum = 0;
        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            for (Integer integer : queue) {
                sum += integer;
            }
            System.out.println(sum);
        }

    }
}
