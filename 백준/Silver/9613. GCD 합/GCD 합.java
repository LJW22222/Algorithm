import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int a = Integer.parseInt(st.nextToken());

        for (int i = 0; i < a; i++) {
            long sum = 0;
            st = new StringTokenizer(sc.nextLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int[] dataList = new int[i1];
            for (int j = 0; j < i1; j++) {
                dataList[j] = Integer.parseInt(st.nextToken());
            }

            for (int aa = 0; aa < dataList.length-1; aa++) {
                for (int jj = aa + 1; jj < dataList.length; jj++) {
                    sum += gcd(dataList[aa], dataList[jj]);
                }
            }
            bw.append(String.valueOf(sum)).append("\n");
        }
        bw.flush();
    }

    private static int gcd(int a, int b){
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}