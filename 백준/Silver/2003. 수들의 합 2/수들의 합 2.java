import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] dataList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dataList = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPoint());
    }

    public static int twoPoint() {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while (left <= N || right <= N) {
            if (sum >= M) {
                if (sum == M) {
                    count+= 1;
                }
                if (left < N) {
                    sum -= dataList[left];
                    left +=1;
                }

            } else if(sum < M){
                if (right == N) {
                    break;
                }
                sum += dataList[right];
                right += 1;
            }
        }
        return count;
    }
}
