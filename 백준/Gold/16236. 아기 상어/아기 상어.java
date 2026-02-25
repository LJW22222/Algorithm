import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int babySharkSize;
    private static int babySharkCount;
    private static int[][] dataList;
    private static int result;


    private static int[][] direction = {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0}
    };
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        babySharkSize = 2;
        babySharkCount = 0;

        int x = 0;
        int y = 0;
        result = 0;

        boolean status = true;

        dataList = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 9) {
                    x = i;
                    y = j;
                }
                if (number != 0 && number != 9) {
                    status = false;
                }

                dataList[i][j] = number;
            }
        }

        if (status) {
            System.out.println(0);
            return;
        }

        FirstBFS(x, y);

        System.out.println(result);
    }

    private static void FirstBFS(int x, int y) {
        while (true) {
            Fish fish = SecondsBFS(x, y, result);
            if (fish == null) {
                return;
            }

            int fishX = fish.x;
            int fishY = fish.y;
            int fishCost = fish.dist;

            babySharkCount += 1;
            if (babySharkCount == babySharkSize) {
                babySharkCount = 0;
                babySharkSize += 1;
            }
            dataList[x][y] = 0;
            dataList[fishX][fishY] = 9;

            x = fishX;
            y = fishY;
            result += fishCost;
        }
    }

    private static Fish SecondsBFS(int x, int y, int cost) {
        Queue<Node> queue = new LinkedList<>();
        List<Fish> fishList = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pollX = poll.x;
            int pollY = poll.y;
            int pollCost = poll.cost;

            checkLocation(pollX, pollY, pollCost, queue, fishList, visited);
        }

        if (fishList.isEmpty()) {
            return null;
        }

        Collections.sort(fishList);

        return fishList.get(0);
    }

    private static void checkLocation(int x, int y, int cost, Queue<Node> queue, List<Fish> fishList, boolean[][] visited) {
        for (int[] ints : direction) {
            int plusX = x + ints[0];
            int plusY = y + ints[1];
            int plusCost = cost + 1;

            if (plusX < 0 || plusY < 0 || plusX >= N || plusY >= N) {
                continue;
            }

            if (visited[plusX][plusY]) {
                continue;
            }

            if (dataList[plusX][plusY] > babySharkSize && dataList[plusX][plusY] != 9 && dataList[plusX][plusY] != 0) {
                continue;
            }

            if (dataList[plusX][plusY] < babySharkSize && dataList[plusX][plusY] != 9 && dataList[plusX][plusY] != 0 ) {
                fishList.add(new Fish(plusX, plusY, plusCost));
            }

            visited[plusX][plusY] = true;
            queue.add(new Node(plusX, plusY, plusCost));
        }
    }

    private static class Fish implements Comparable<Fish>{
        int x;
        int y;
        int dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {

            if (this.dist != o.dist)
                return this.dist - o.dist;

            if (this.x != o.x)
                return this.x - o.x;

            return this.y - o.y;
        }
    }


    private static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}