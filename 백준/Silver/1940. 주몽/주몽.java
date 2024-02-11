import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader In = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(In.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(In.readLine());
        int[] dataList = new int[A];
        st = new StringTokenizer(In.readLine());
        for (int i = 0; i < A; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dataList);
        int Apoint = 0;
        int Bpoint = A-1;
        int count = 0;
        while (true){
            if (Apoint == Bpoint) {
                break;
            }else if(dataList[Apoint] + dataList[Bpoint] < B){
                Apoint++;
            }else if(dataList[Apoint] + dataList[Bpoint] > B){
                Bpoint--;
            }else{
                Bpoint--;
                count++;
            }
        }
        System.out.println(count);
    }
}
