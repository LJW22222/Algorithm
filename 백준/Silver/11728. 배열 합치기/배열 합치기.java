import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] listA = new int[A];
        int[] listB = new int[B];

        ArrayList<Integer> resultList = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < A; i++) {
            resultList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < B; i++) {
            resultList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(resultList);

        for (Integer i : resultList) {
            bw.append(String.valueOf(i)).append(" ");
        }

        bw.flush();


    }
}
