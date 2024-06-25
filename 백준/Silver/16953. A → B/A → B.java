import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        DFS(A, B);
        System.out.println(count);
    }

    static void DFS(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(b);
        int i = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            String[] split = poll.toString().split("");
            String s = split[split.length - 1];
            if (s.equals("1")) {
                i = (poll - 1) / 10;
            } else if (poll % 2 != 0) {
                count = -1;
                break;
            } else {
                i = poll / 2;
            }
            count++;
            if (i < a) {
                count = -1;
                break;
            }
            if (i <= 1 || i == a) {
                break;
            }
            queue.add(i);
        }
    }

}
