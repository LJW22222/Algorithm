import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static boolean[] visited;

    static int[] AList;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        AList = new int[101];
        visited = new boolean[101];

        for (int i = 0; i < A + B; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int A1 = Integer.parseInt(st.nextToken());
            int B1 = Integer.parseInt(st.nextToken());
            AList[A1] = B1;
        }
        BFS();

    }

    static void BFS() {
        Queue<Node> result = new LinkedList<>();
        visited[1] = true;
        result.add(new Node(1, 1));
        while (!result.isEmpty()) {
            int numbers = 0;
            Node poll = result.poll();
            int i = 1;
            while (i <= 6) {
                if (poll.A + i == 100) {
                    numbers = 100;
                    break;
                }
                if (AList[poll.A + i] != 0 || AList[poll.A + i] > poll.A + i) {
                    if (!visited[AList[poll.A+i]]) {
                        result.add(new Node(AList[poll.A + i], poll.B + 1));
                        visited[poll.B] = true;
                    }
                } else {
                    if (!visited[poll.A + i]) {
                        result.add(new Node(poll.A + i, poll.B + 1));
                        visited[poll.A + i] = true;
                    }
                }
                i++;
            }
            if (numbers == 100) {
                System.out.println(poll.B);
                break;
            }

        }
    }

    static class Node {
        int A;
        int B;

        public Node(int a, int b) {
            A = a;
            B = b;
        }
    }

}
