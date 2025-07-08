import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][][] visited;
    static int A;
    static int B;
    static int[][] dataList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<Integer, Node> pointList = new HashMap<>();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dataList = new int[A][B];
        visited = new boolean[4][A][B];
        int c = 1;
        for (int i = 0; i < A + 2; i++) {
            st = new StringTokenizer(bf.readLine());
            if (i < A) {
                for (int j = 0; j < B; j++) {
                    dataList[i][j] = Integer.parseInt(st.nextToken());
                }
            } else {
                int startRow = Integer.parseInt(st.nextToken()) - 1;
                int startCol = Integer.parseInt(st.nextToken()) - 1;
                int inDir = Integer.parseInt(st.nextToken());

                int startDir;
                switch (inDir) {
                    case 1:
                        startDir = 0; // 동
                        break;
                    case 2:
                        startDir = 1; // 서
                        break;
                    case 3:
                        startDir = 2; // 남
                        break;
                    default:
                        startDir = 3; // 북
                }
                Node startNode = new Node(startRow, startCol, startDir, 0);
                pointList.put(c, startNode);
                c++;
            }
        }

        BFS(pointList.get(1), pointList.get(2));
    }

    private static void BFS(Node startNode, Node endNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (endNode.a == poll.a && endNode.b == poll.b && endNode.direction == poll.direction) {
                System.out.println(poll.count);
                return;
            }
            int plusCount = poll.count + 1;
            directionConversion(queue, poll, plusCount);
            checkDistance(queue, poll, plusCount);
        }

    }

    private static void directionConversion(Queue<Node> queue, Node node, int plusCount) {
        int left = 0, right = 0;
        switch (node.direction) {
            case 0: 
                left = 3; 
                right = 2; 
                break;
            case 1: 
                left = 2;
                right = 3;
                break;
            case 2: 
                left = 1; 
                break;
            case 3: 
                right = 1; 
                break;
        }

        if (!visited[left][node.a][node.b]) {
            queue.add(new Node(node.a, node.b, left, plusCount));
            visited[left][node.a][node.b] = true;
        }
        if (!visited[right][node.a][node.b]) {
            queue.add(new Node(node.a, node.b, right, plusCount));
            visited[right][node.a][node.b] = true;
        }
    }

    private static void checkDistance(Queue<Node> queue, Node startNode, int plusCount) {
        for (int j = 1; j <= 3; j++) {
            int na = startNode.a;
            int nb = startNode.b;

            if (startNode.direction == 0) {
                nb += j;
            } else if (startNode.direction == 1) {
                nb -= j;
            } else if (startNode.direction == 2) {
                na += j;
            } else if (startNode.direction == 3) {
                na -= j;
            }


            if (na < 0 || nb < 0 || na >= A || nb >= B) {
                break;
            }
            if (dataList[na][nb] == 1) {
                break;
            }

            if (visited[startNode.direction][na][nb]) {
                continue;
            }

            queue.add(new Node(na, nb, startNode.direction, plusCount));
            visited[startNode.direction][na][nb] = true;
        }
    }


    private static class Node {
        int a;
        int b;
        int direction;
        int count;

        public Node(int a, int b, int direction, int count) {
            this.a = a;
            this.b = b;
            this.direction = direction;
            this.count = count;
        }
    }
}
