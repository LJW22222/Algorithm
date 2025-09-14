import java.io.*;
import java.util.*;

public class Main {

    private static int[] left;
    private static int[] right;

    // 전위
    private static StringBuilder pro = new StringBuilder();
    // 중위
    private static StringBuilder ino = new StringBuilder();
    // 후위
    private static StringBuilder pos = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        left = new int[26];
        right = new int[26];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int ad = 0; ad < i; ad++) {
            st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            int i1 = (int) c - 65;
            String leftS = st.nextToken();
            String rightS = st.nextToken();

            int leftA = ".".equals(leftS) ? -1 : leftS.charAt(0) - 65;
            int rightA = ".".equals(rightS) ? -1 : rightS.charAt(0) - 65;
            left[i1] = leftA;
            right[i1] = rightA;
        }


        DFS(0);

        bw.append(pro).append("\n").append(ino).append("\n").append(pos).append("\n");
        bw.flush();
    }
    private static void DFS(int number) {
        if (number == -1 ) {
            return;
        }

        pro.append((char) (number + 65));
        DFS(left[number]);
        ino.append((char) (number + 65));
        DFS(right[number]);
        pos.append((char) (number + 65));
    }
}
