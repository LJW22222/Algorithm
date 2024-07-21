import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] dataList;

    static boolean[][] visitedList;

    static Queue<Node> qList;

    static int count;

    static int A;
    static int B;

    //DFS 사용
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dataList = new int[A][B];
        visitedList = new boolean[A][B];

        qList = new LinkedList<>();

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < B; j++) {
                dataList[i][j] = Integer.parseInt(st.nextToken());
                if (dataList[i][j] == 9) {
                    qList.add(new Node(i, j, 0));
                    visitedList[i][j] = true;
                    count++;
                }
            }
        }

        BFS();
        System.out.println(count);

    }

    static void BFS() {
        while (!qList.isEmpty()) {
            Node poll = qList.poll();
            addNode(poll.x, poll.y, poll.k);
        }

    }

    static void ddd(int x, int y, int k, int k3) {
        if (!visitedList[x][y]) {
            count++;
        }
        visitedList[x][y] = true;
        if (dataList[x][y] == 0) {
            qList.add(new Node(x, y, k3));
        } else if (dataList[x][y] == 1) {
            if (k == 2 || k == 1) {
                qList.add(new Node(x, y, k3));
            }
        } else if (dataList[x][y] == 2) {
            if (k == 3 || k == 4) {
                qList.add(new Node(x, y, k3));
            }
        } else if (dataList[x][y] == 3) {
            if (k == 1) {
                qList.add(new Node(x, y, 4));
            } else if (k == 2) {
                qList.add(new Node(x, y, 3));
            } else if (k == 3) {
                qList.add(new Node(x, y, 2));
            } else if (k == 4) {
                qList.add(new Node(x, y, 1));
            }
        } else if (dataList[x][y] == 4) {
            if (k == 1) {
                qList.add(new Node(x, y, 3));
            } else if (k == 2) {
                qList.add(new Node(x, y, 4));
            } else if (k == 3) {
                qList.add(new Node(x, y, 1));
            } else if (k == 4) {
                qList.add(new Node(x, y, 2));
            }
        }
    }

    static void addNode(int x, int y, int k) {
        //아래쪽
        if (x + 1 < A && (k == 1 || k == 0)) {
            if (k == 0) {
                ddd(x + 1, y, 1, 1);
            } else {
                ddd(x + 1, y, k, 1);
            }
        }
        //오른쪽
        if (y + 1 < B && (k == 3 || k == 0)) {
            if (k == 0) {
                ddd(x, y + 1, 3, 3);
            } else {
                ddd(x, y + 1, k, 3);
            }
        }
        //위쪽
        if (x - 1 >= 0 && (k == 2 || k == 0)) {
            if (k == 0) {
                ddd(x - 1, y, 2, 2);
            } else {
                ddd(x - 1, y, k, 2);
            }
        }
        //왼쪽
        if (y - 1 >= 0 && (k == 4 || k == 0)) {
            if (k == 0) {
                ddd(x, y - 1, 4, 4);
            } else {
                ddd(x, y - 1, k, 4);
            }
        }
    }

    static class Node {
        int x;
        int y;

        int k;

        public Node(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }

    }

}
