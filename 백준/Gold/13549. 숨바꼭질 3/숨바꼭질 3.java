import java.io.IOException;
import java.util.*;

public class Main {

    private static int K;
    private static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS(N);

    }

    // 가중치 1 -> X-1 or X+1
    // 가중치 0 -> 2*X
    // Deque에 넣을 때는 가중치가 0은 앞에, 1은 뒤에 넣기
    // 값을 뺄때는 Deque 앞에서 빼기
    public static void BFS(int data) {
        Deque<int[]> dataList = new ArrayDeque<>();
        dataList.add(new int[]{data, 0});

        //거리 배열
        int[] dist = new int[100_000 * 2 + 2];
        Arrays.fill(dist, INF);
        dist[data] = 0;

        while (!dataList.isEmpty()) {
            int[] getData = dataList.pollFirst();
            int location = getData[0];
            int time = getData[1];

            // getData가 K보다 작은 경우
            //  -
            if (location * 2 <= K * 2) {
                if (dist[location * 2] > dist[location]) {
                    dataList.addFirst(new int[]{location * 2, time});
                    dist[location * 2] = dist[location];
                }
            }

            if (location + 1 <= K * 2) {
                if (dist[location + 1] > dist[location] + time) {
                    dataList.addLast(new int[]{location + 1, time + 1});
                    dist[location + 1] = dist[location] + 1;
                }
            }

            if (location - 1 >= 0) {
                if (dist[location - 1] > dist[location] + time) {
                    dataList.addLast(new int[]{location - 1, time + 1});
                    dist[location - 1] = dist[location] + 1;
                }
            }

        }

        System.out.println(dist[K]);
    }
}
