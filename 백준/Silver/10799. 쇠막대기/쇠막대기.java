import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String s = st.nextToken();
        String[] split = s.split("");

        Stack<String> dataList = new Stack<>();
        int count = 0;
        String before = "A";
        for (String string : split) {
            if (before.equals(")") && ")".equals(string)) {
                dataList.pop();
                count++;
            }else if (")".equals(string)) {
                String pop = dataList.pop();
                if ("(".equals(pop)) {
                    count += dataList.size();
                }
            } else {
                dataList.push(string);
            }
            before = string;
        }
        System.out.println(count);



    }
}
