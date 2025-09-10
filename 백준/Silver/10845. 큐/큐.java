import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int i1 = Integer.parseInt(st.nextToken());

        Deque<Integer> queueList = new ArrayDeque<>();
        for (int i = 0; i < i1; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            String s = st.nextToken();
            if ("push".equals(s)) {
                queueList.add(Integer.parseInt(st.nextToken()));
            } else if ("front".equals(s)) {
                if (queueList.isEmpty()) {
                    bw.append("-1").append("\n");
                } else {
                    bw.append(String.valueOf(queueList.peekFirst())).append("\n");
                }
            } else if ("back".equals(s)) {
                if (queueList.isEmpty()) {
                    bw.append("-1").append("\n");
                } else {
                    bw.append(String.valueOf(queueList.peekLast())).append("\n");
                }

            } else if ("empty".equals(s)) {
                if (queueList.isEmpty()) {
                    bw.append("1").append("\n");
                } else {
                    bw.append("0").append("\n");
                }
            } else if ("size".equals(s)) {
                bw.append(String.valueOf(queueList.size())).append("\n");
            } else if ("pop".equals(s)) {
                if (queueList.isEmpty()) {
                    bw.append("-1").append("\n");
                } else {
                    bw.append(String.valueOf(queueList.pollFirst())).append("\n");
                }
            }
        }
        bw.flush();

    }
}
