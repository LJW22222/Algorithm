import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long[] dataList = new long[a];
        dataList[0] = 1;

        for (int i = 1; i < a; i++) {
            if (i == 1) {
                dataList[i] = 1;
                continue;
            }
            dataList[i] = dataList[i - 2] + dataList[i - 1];
        }
        System.out.println(dataList[a-1]);
    }
}

