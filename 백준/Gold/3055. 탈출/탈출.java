import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Node> dataList;

    static Queue<Node> waterdataList;

    static Queue<Node> subQueue;

    static boolean[][] waterVisited;
    static boolean[][] visited;

    static int A;
    static int B;

    static Node dd;

    static String[][] map;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new String[A][B];
        dataList = new LinkedList<>();
        waterdataList = new LinkedList<>();
        waterVisited = new boolean[A][B];
        visited = new boolean[A][B];
        subQueue = new LinkedList<>();
        boolean button = false;
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(in.readLine());
            String[] split = st.nextToken().split("");
            for (int j = 0; j < B; j++) {
                if (split[j].equals("S")) {
                    subQueue.add(new Node(i, j));
                    visited[i][j] = true;
                } else if (split[j].equals("*")) {
                    waterdataList.add(new Node(i, j));
                    waterVisited[i][j] = true;
                } else if (split[j].equals("D")) {
                    dd = new Node(i, j);
                }
                map[i][j] = split[j];
            }
        }
        int i = moveBFS();
        if (i > 0) {
            System.out.println(count);
        } else {
            System.out.println("KAKTUS");
        }



    }

    static int moveBFS() {
        while (!subQueue.isEmpty()) {
            dataList.addAll(subQueue);
            subQueue.clear();
            waterBFS();
            count++;
            while (!dataList.isEmpty()) {
                Node poll = dataList.poll();
                int X = poll.x;
                int Y = poll.y;
                if (X + 1 < A && !visited[X + 1][Y] && !map[X + 1][Y].equals("X") && !map[X + 1][Y].equals("*")) {
                    if (map[X + 1][Y].equals("D")) {
                        return count;
                    }
                    map[X + 1][Y] = "S";
                    visited[X + 1][Y] = true;
                    subQueue.add(new Node(X + 1, Y));
                }
                if (X - 1 >= 0 && !visited[X - 1][Y] && !map[X - 1][Y].equals("X") && !map[X - 1][Y].equals("*")) {
                    if (map[X - 1][Y].equals("D")) {
                        return count;
                    }
                    map[X - 1][Y] = "S";
                    visited[X - 1][Y] = true;
                    subQueue.add(new Node(X - 1, Y));
                }
                if (Y + 1 < B && !visited[X][Y + 1] && !map[X][Y + 1].equals("X") && !map[X][Y + 1].equals("*")) {
                    if (map[X][Y+1].equals("D")) {
                        return count;
                    }
                    map[X][Y + 1] = "S";
                    visited[X][Y + 1] = true;
                    subQueue.add(new Node(X, Y + 1));
                }
                if (Y - 1 >= 0 && !visited[X][Y - 1] && !map[X][Y - 1].equals("X") && !map[X][Y - 1].equals("*")) {
                    if (map[X][Y-1].equals("D")) {
                        return count;
                    }
                    map[X][Y - 1] = "S";
                    visited[X][Y - 1] = true;
                    subQueue.add(new Node(X, Y - 1));
                }
            }
        }
        return -1;
    }

    static void waterBFS() {
        Queue<Node> queue = new LinkedList<>(waterdataList);
        waterdataList.clear();
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int X = poll.x;
            int Y = poll.y;
            if (X + 1 < A && !waterVisited[X + 1][Y] && !map[X + 1][Y].equals("X") && !map[X + 1][Y].equals("D")) {
                map[X + 1][Y] = "*";
                waterVisited[X + 1][Y] = true;
                waterdataList.add(new Node(X + 1, Y));
            }
            if (X - 1 >= 0 && !waterVisited[X - 1][Y] && !map[X - 1][Y].equals("X") && !map[X - 1][Y].equals("D")) {
                map[X - 1][Y] = "*";
                waterVisited[X - 1][Y] = true;
                waterdataList.add(new Node(X - 1, Y));
            }
            if (Y + 1 < B && !waterVisited[X][Y + 1] && !map[X][Y + 1].equals("X") && !map[X][Y + 1].equals("D")) {
                map[X][Y + 1] = "*";
                waterVisited[X][Y + 1] = true;
                waterdataList.add(new Node(X, Y + 1));
            }
            if (Y - 1 >= 0 && !waterVisited[X][Y - 1] && !map[X][Y - 1].equals("X") && !map[X][Y - 1].equals("D")) {
                map[X][Y - 1] = "*";
                waterVisited[X][Y - 1] = true;
                waterdataList.add(new Node(X, Y - 1));
            }

        }

    }


    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

