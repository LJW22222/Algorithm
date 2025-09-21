import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long[][] dpTable = new long[a+1][10];

        for (int i = 0; i <= 9; i++) {
            dpTable[1][i] = 1;
        }

        if (a == 1) {
            System.out.print("10");
            return;
        }
        for (int i = 2; i <= a; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dpTable[i][j] = 1;
                } else if (j == 9) {
                    dpTable[i][j] = (dpTable[i][8] + dpTable[i-1][9]) % 10_007;
                } else {
                    dpTable[i][j] = (dpTable[i][j - 1] + dpTable[i-1][j]) % 10_007;
                }

            }
        }
        long sum = 0;
            for (int j = 0; j <= 9; j++) {
                sum += dpTable[a][j];
            }

        System.out.println(sum % 10_007);
    }
}
