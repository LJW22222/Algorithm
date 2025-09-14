import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String A = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        Map<Long, Long> dataList = new HashMap<>();
        long kk = 0;
        while (true) {
            long sum = 0;
            dataList.put(Long.parseLong(A), kk);

            String[] split = A.split("");
            for (String s : split) {
                int i = Integer.parseInt(s);
                sum += (long) Math.pow(i, B);
            }

            if (dataList.containsKey(sum)) {
                System.out.println(dataList.get(sum));
                break;
            }
            A = String.valueOf(sum);
            kk++;
        }
    }

}