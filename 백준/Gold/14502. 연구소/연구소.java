import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int a;
    static int b;
    static int[][] dataList;
    static int[][] subdataList;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        dataList = new int[a][b];
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < b; j++) {
                dataList[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        wa(0);
        System.out.println(pq.poll());

    }

    private static void wa(int count) {
        if (count == 3) {
            subdataList = new int[a][b];
            for (int i = 0; i < dataList.length; i++) {
                System.arraycopy(dataList[i], 0, subdataList[i], 0, dataList[0].length);
            }
            BFS();
            checkBox1();
            return;
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (dataList[i][j] == 0) {
                    dataList[i][j] = 1;
                    wa(count + 1);
                    dataList[i][j] = 0;
                }
            }
        }
    }

    private static void checkBox1() {
        int count = 0;
        for (int[] ints : subdataList) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    count+=1;
                }
            }
        }
        pq.add(count);
    }

    private static void BFS() {
        Queue<NodeN> queue = new LinkedList<>();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (subdataList[i][j] == 2) {
                    queue.add(new NodeN(i,j));
                }
            }
        }
        while (!queue.isEmpty()) {
            NodeN poll = queue.poll();
            int a1 = poll.a;
            int b1 = poll.b;
            if (a1 - 1 >= 0 && subdataList[a1-1][b1] == 0) {
                queue.add(new NodeN(a1-1,b1));
                subdataList[a1-1][b1] = 2;
            }
            if (b1 - 1 >= 0 && subdataList[a1][b1-1] == 0) {
                queue.add(new NodeN(a1,b1-1));
                subdataList[a1][b1-1] = 2;
            }
            if (a1 + 1 < a && subdataList[a1+1][b1] == 0) {
                queue.add(new NodeN(a1+1,b1));
                subdataList[a1+1][b1] = 2;
            }
            if (b1 + 1 < b && subdataList[a1][b1+1] == 0) {
                queue.add(new NodeN(a1,b1+1));
                subdataList[a1][b1+1] = 2;
            }
        }
    }

    static class NodeN {
        int a;
        int b;

        public NodeN(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
