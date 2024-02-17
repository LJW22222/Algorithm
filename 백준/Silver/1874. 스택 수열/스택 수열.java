
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int[] numberset = new int[A];
        Stack<Integer> resultData = new Stack<>();
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(in.readLine());
            int data = Integer.parseInt(st.nextToken());
            numberset[i] = data;
        }
        int nn = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A; i++) {
            int C = numberset[i];
            if(nn <= C) {
                while (nn <= C) {
                    resultData.push(nn);
                    sb.append("+\n");
                    nn++;
                }
                resultData.pop();
                sb.append("-\n");
            } else {
                if (!resultData.isEmpty() && resultData.peek() == C){
                    resultData.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    in.close();
                    return;
                }
            }
        }
        System.out.println(sb);
        in.close();
    }
}