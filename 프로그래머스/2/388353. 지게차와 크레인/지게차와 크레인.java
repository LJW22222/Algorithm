import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private String[][] dataList;
    private boolean[][] visited;
    private int n;
    private int m;

    private final int[][] location = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int solution(String[] storage, String[] requests) {
        n = storage.length + 2;
        m = storage[0].length() + 2;

        dataList = new String[n][m];

        for (String[] row : dataList) {
            Arrays.fill(row, "0");
        }

        for (int i = 0; i < storage.length; i++) {
            String[] split = storage[i].split("");
            System.arraycopy(split, 0, dataList[i + 1], 1, storage[i].length());
        }

        for (String request : requests) {
            layerRotation(request, storage);
        }

        int answer = 0;
        for (String[] row : dataList) {
            for (String value : row) {
                if (!value.equals("0")) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void layerRotation(String request, String[] storage) {
        if (request.length() == 2) {
            String target = String.valueOf(request.charAt(0));
            for (int i = 0; i < storage.length; i++) {
                for (int j = 0; j < storage[i].length(); j++) {
                    if (dataList[i + 1][j + 1].equals(target)) {
                        dataList[i + 1][j + 1] = "0";
                    }
                }
            }
            return;
        }
        visited = new boolean[n][m];
        bfs(request);
    }

    private void bfs(String target) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentI = current[0];
            int currentJ = current[1];
            checkBox(currentI, currentJ, target, queue);
        }
    }

    private void checkBox(int i, int j, String target, Queue<int[]> queue) {
        for (int[] move : location) {
            int nextI = i + move[0];
            int nextJ = j + move[1];

            if (nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= m) {
                continue;
            }

            if (visited[nextI][nextJ]) {
                continue;
            }

            visited[nextI][nextJ] = true;

            if (dataList[nextI][nextJ].equals(target)) {
                dataList[nextI][nextJ] = "0";
                continue;
            }

            if (dataList[nextI][nextJ].equals("0")) {
                queue.add(new int[]{nextI, nextJ});
            }
        }
    }
}