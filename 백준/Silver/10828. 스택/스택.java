import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int i1 = Integer.parseInt(st.nextToken());
        Stack<Integer> dataList = new Stack<>();
        for (int i = 0; i < i1; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            String order = st.nextToken();
            if ("push".equals(order)) {
                int number = Integer.parseInt(st.nextToken());
                dataList.push(number);
                continue;
            }
            if ("pop".equals(order)) {
                if (dataList.isEmpty()) {
                    bw.append("-1").append("\n");
                    continue;
                }
                Integer pop = dataList.pop();
                bw.append(String.valueOf(pop)).append("\n");
                continue;
            }

            if ("size".equals(order)) {
                bw.append(String.valueOf(dataList.size())).append("\n");
                continue;
            }

            if ("empty".equals(order)) {
                if (dataList.isEmpty()) {
                    bw.append("1").append("\n");
                } else {
                    bw.append("0").append("\n");
                }
                continue;
            }

            if ("top".equals(order)) {
                if (dataList.isEmpty()) {
                    bw.append("-1").append("\n");
                } else {
                    bw.append(String.valueOf(dataList.peek())).append("\n");
                }
            }
        }
        bw.flush();
    }
}
