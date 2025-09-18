import java.io.IOException;
import java.util.*;

public class Main {

    private static boolean[] visited;
    private static int[] dataList;
    private static final Deque<Integer> deque = new ArrayDeque<>();
    private static int a;
    private static final List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        a = Integer.parseInt(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        dataList = new int[a];

        for (int i = 0; i < a; i++) {
            int i1 = Integer.parseInt(st.nextToken());
            dataList[i] = i1;
        }
        int[] newDataList = new int[a];
        for (int i = 0; i < a; i++) {
            visited = new boolean[a];
            newDataList[0] = dataList[i];
            visited[i] = true;
            sort(1, newDataList);
        }
        System.out.println(Collections.max(resultList));
    }

    private static void sort(int number, int[] newDataList) {
        if (number == a) {
            int sum = 0;
            for (int i = 0; i < a-1; i++) {
                sum += Math.abs(newDataList[i] - newDataList[i + 1]);
            }
            resultList.add(sum);
            return;
        }

        for (int i = 0; i < a; i++) {
            if (!visited[i]) {
                visited[i] = true;
                newDataList[number] = dataList[i];
                sort(number + 1, newDataList);
                visited[i] = false;
            }
        }

    }
}

