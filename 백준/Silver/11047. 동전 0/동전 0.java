import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static Integer[] dataList;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        dataList = new Integer[A];
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(in.readLine());
            dataList[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = A-1; i >= 0; i--) {
            result += B / dataList[i];
            B -= dataList[i] * (B / dataList[i]);
        }
        System.out.println(result);
    }
}
