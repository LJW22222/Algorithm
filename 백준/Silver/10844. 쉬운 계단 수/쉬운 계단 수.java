import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long[][] dpTable = new long[a+1][10];

        for (int i = 1; i <= 9; i++) {
            dpTable[1][i] = 1;
        }

        if (a == 1) {
            System.out.println(dpTable[0].length - 1);
            return;
        }

        long sum = 0;
        for (int i = 2; i <= a; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0 || j == 9) {
                    if (j == 0) dpTable[i][j] = dpTable[i - 1][1] % 1_000_000_000;
                    if (j == 9) dpTable[i][j] = dpTable[i - 1][8] % 1_000_000_000;
                } else {
                    dpTable[i][j] = (dpTable[i - 1][j - 1] + dpTable[i - 1][j + 1]) % 1_000_000_000;
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            sum = (sum + dpTable[a][i]) % 1_000_000_000;
        }

        System.out.println(sum);

    }
}
