import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int[] dataList = new int[a + 1];
        for (int i = 2; i <= a; i++) {
            int dd = 0;
            if (i % 2 == 0 && i % 3 == 0) {
                dd = Math.min(dataList[i / 2] + 1, dataList[i / 3] + 1);
            }else if (i % 2 == 0) {
                dd = dataList[i / 2] + 1;
            } else if (i % 3 == 0) {
                dd = dataList[i / 3] + 1;
            }

            if (dd == 0) {
                dataList[i] = dataList[i - 1] + 1;
                continue;
            }
            dataList[i] = Math.min(dd, dataList[i - 1] + 1);
        }
        System.out.println(dataList[dataList.length-1]);
    }
}

