import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

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
            if ("push_front".equals(s)) {
                queueList.addFirst(Integer.parseInt(st.nextToken()));
            } else if ("push_back".equals(s)) {
                queueList.addLast(Integer.parseInt(st.nextToken()));
            } else if ("pop_front".equals(s)) {
                if (queueList.isEmpty()) {
                    bw.append("-1").append("\n");
                } else {
                    bw.append(String.valueOf(queueList.pollFirst())).append("\n");
                }
            } else if ("pop_back".equals(s)) {
                if (queueList.isEmpty()) {
                    bw.append("-1").append("\n");
                } else {
                    bw.append(String.valueOf(queueList.pollLast())).append("\n");
                }
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
            }
        }
        bw.flush();

    }
}
