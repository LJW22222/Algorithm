import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>(new nodeComparator());
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(in.readLine());
            int cc = Integer.parseInt(st.nextToken());
            int dd = Integer.parseInt(st.nextToken());
            pq.add(new Node(cc, dd));
        }
        int c = Objects.requireNonNull(pq.poll()).endTime;
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            int endTime = poll.endTime;
            int startTime = poll.startTime;
            if (c <= startTime) {
                count++;
                c = endTime;
            }
        }

        System.out.println(count);
    }

    static class nodeComparator implements Comparator<Node> {

         @Override
        public int compare(Node o1, Node o2) {
            if (o1.endTime == o2.endTime) {
                return o1.startTime - o2.startTime;
            }else {
                return o1.endTime - o2.endTime;
            }
        }
    }

    static class Node {
        int startTime;
        int endTime;


        public Node(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }


    }

}
