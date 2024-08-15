import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bu.readLine());

        int N = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            int Number = 0;
            int dNumber = 0;
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(bu.readLine());
            Deque<String> dequeList = new LinkedList<>();

            String[] s = st.nextToken().split("");
            st = new StringTokenizer(bu.readLine());
            int t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bu.readLine());
            String s1 = st.nextToken();
            String[] split = s1.substring(1, s1.length() - 1).split(",");
            for (String value : split) {
                dequeList.addLast(value);
            }

            visited = new boolean[s.length];

            for (String s2 : s) {

                if (s2.equals("R")) {
                    Number += 1;
                } else if (s2.equals("D")) {
                    dNumber += 1;
                    if (Number % 2 != 0) {
                        dequeList.pollLast();
                    } else {
                        dequeList.pollFirst();
                    }
                }
            }
            if (dNumber > t) {
                bw.write("error");
            } else {
                while (!dequeList.isEmpty()) {
                    if (Number % 2 != 0) {
                        sb.append(dequeList.pollLast()).append(",");
                    } else {
                        sb.append(dequeList.pollFirst()).append(",");
                    }

                }
                if(sb.length() == 0){
                    bw.write("[]");
                }else {
                    sb.setLength(sb.length() - 1);
                    bw.write("[" + sb + "]");
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
