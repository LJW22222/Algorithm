
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] vList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        vList = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            vList[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost
        );

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new Node(A, B, C));
        }
        MTS(pq);
    }

    private static void MTS(PriorityQueue<Node> pq) {
        int price = 0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int a = find(poll.from);
            int b = find(poll.to);

            if (a != b) {
                union(poll.to, poll.from);
                price += poll.cost;
            }


        }
        System.out.println(price);
    }

    private static void union(int a, int b) {
        int i = find(a);
        int i1 = find(b);

        vList[i1] = i;
    }

    private static int find(int x) {
        if (x == vList[x]) {
            return x;
        }
        vList[x] = find(vList[x]);
        return vList[x];
    }

    private static class Node {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }

}
