import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static char[] dataList;
    private static int A;
    private static int B;
    private static boolean[] visited;
    private static char[] resultList;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final char[] checkList = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dataList = new char[B];
        visited = new boolean[B];
        resultList = new char[A];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < B; i++) {
            String s = st.nextToken();
            dataList[i] = s.charAt(0);
        }
        Arrays.sort(dataList);
        DFS(0, 0);
        bw.flush();
    }

    private static void DFS(int start, int depth) throws IOException {
        if (depth == A) {
            int count = 0;
            for (int i = 0; i < A; i++) {
                for (char c : checkList) {
                    if (c == resultList[i]) {
                        count++;
                        break;
                    }
                }
            }

            int i = A - count;

            if (count < 1 || i < 2) {
                return;
            }

            for (char c : resultList) {
                bw.append(String.valueOf(c));
            }
            bw.append("\n");
            return;
        }
        for (int j = start; j < B; j++) {
                resultList[depth] = dataList[j];
                DFS(j+1, depth + 1);
        }

    }

}
