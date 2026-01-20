import java.io.*;
import java.util.*;

public class Main {

    private static int INF = 100_000_000;
    private static int[] costList;
    private static List<Node>[] computerList;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            computerList = new ArrayList[n + 1];
            for (int i1 = 1; i1 <= n; i1++) {
                computerList[i1] = new ArrayList<>();
            }
            costList = new int[n + 1];
            Arrays.fill(costList, INF);

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                computerList[b].add(new Node(a, s));
            }

            if (costList[c] == INF) {
                costList[c] = 0;
            }

            graph(c);

            int sum = Arrays.stream(costList)
                    .filter(v -> v != INF)
                    .max()
                    .orElse(0);
            long count = Arrays.stream(costList).filter(n -> n != INF).count();


            bw.append(String.valueOf(count)).append(" ").append(String.valueOf(sum)).append("\n");
        }
        bw.flush();
    }

    private static void graph(int c) {
        PriorityQueue<Node> queue = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost
        );
        queue.add(new Node(c, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int next = poll.next;
            int cost = poll.cost;
            addQueue(next, cost, queue);
        }
    }

    private static void addQueue(int next, int cost, PriorityQueue<Node> queue) {
        if (costList[next] < cost) return;

        for (Node nxt : computerList[next]) {
            int nd = cost + nxt.cost;
            if (nd < costList[nxt.next]) {
                costList[nxt.next] = nd;
                queue.add(new Node(nxt.next, nd));
            }
        }
    }


    private static class Node {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}
