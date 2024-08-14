import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bu.readLine());
        StringBuilder sb = new StringBuilder();
        BufferedWriter bs = new BufferedWriter(new OutputStreamWriter(System.out));
        sb.append("<");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<Integer> list = new LinkedList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            list.add(i);
        }

        for (int i = 0; i < A; i++) {
            for (int z = 0; z < B-1; z++) {
                Integer poll = list.poll();
                list.add(poll);
            }
            sb.append(list.poll()).append(", ");
        }
        sb.setLength(sb.length()-2);
        bs.write(sb.append(">").toString());
        bs.flush();

    }
}
