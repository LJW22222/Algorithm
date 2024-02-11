import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] dataList = new int[A];
        for (int i = 0; i < A; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dataList);
        int count = 0;
        for (int c = 0; c < A; c++) {
            Long number = (long) dataList[c];
            int Apoint = 0;
            int Bpoint = A-1;
            while (Apoint < Bpoint) {
                if (dataList[Apoint] + dataList[Bpoint] > number) {
                    Bpoint--;
                }else if(dataList[Apoint] + dataList[Bpoint] < number){
                    Apoint++;
                } else if (dataList[Apoint] + dataList[Bpoint] == number) {
                    if (Apoint == c) {
                        Apoint++;
                    } else if (Bpoint == c) {
                        Bpoint--;
                    }else if(Bpoint != c && Apoint != c){
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}