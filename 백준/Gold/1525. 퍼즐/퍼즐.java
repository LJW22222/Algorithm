import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] dataList;
    private static List<Integer>[] dataList2;

    private static final int[][] changeLocationG = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dataList = new int[3][3];

        StringBuilder start = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                start.append(i1);
                dataList[i][j] = i1;
            }
        }

        dataList2 = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            dataList2[i] = new ArrayList<>();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int from = i * 3 + j;
                for (int[] d : changeLocationG) {
                    int ni = i + d[0], nj = j + d[1];
                    if (0 <= ni && ni < 3 && 0 <= nj && nj < 3) {
                        int to = ni * 3 + nj;
                        dataList2[from].add(to);
                    }
                }
            }
        }

        BFS(start.toString());
    }

    private static void BFS(String start) {
        Queue<String> dataQueue = new ArrayDeque<>();
        HashMap<String, Integer> visitedList = new HashMap<>();
        visitedList.put(start, 0);
        dataQueue.add(start);
        while (!dataQueue.isEmpty()) {
            String poll = dataQueue.poll();
            if (poll.equals("123456780")) {
                Integer i = visitedList.get(poll);
                System.out.println(i);
                return;
            }
            changeLocation(poll, dataQueue, visitedList);
        }
        System.out.println("-1");
    }

    private static void changeLocation(String start, Queue<String> dataQueue, HashMap<String, Integer> visitedList) {
        char[] charArray = start.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                List<Integer> integers = dataList2[i];
                for (Integer integer : integers) {
                    String s = new String(charArray);
                    char[] charArray1 = s.toCharArray();

                    char c = charArray1[i];
                    charArray1[i] = charArray[integer];
                    charArray1[integer] = c;
                    String s1 = new String(charArray1);
                    if (visitedList.containsKey(s1)) {
                        continue;
                    }

                    visitedList.put(s1, visitedList.get(start) + 1);

                    dataQueue.add(s1);
                }
            }
        }
    }

}
