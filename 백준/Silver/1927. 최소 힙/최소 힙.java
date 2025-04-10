import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int number = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> dataList = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(bf.readLine());
            int number2 = Integer.parseInt(st.nextToken());
            if (number2 == 0) {
                count += 1;
                if (dataList.isEmpty())
                    sb.append("0").append("\n");
                else
                    sb.append(dataList.poll()).append("\n");
            } else {
                dataList.add(number2);
            }
        }
        System.out.println(sb);
    }
}
