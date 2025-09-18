import java.io.IOException;
import java.util.Scanner;
//DP 문제
//2 x N의 타일 크기를 2 x 1, 1 x 2의 타일들로만 꽉 채울 수 있는 경우의 수를 모두 구해야 함.
//
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int[] tileList = new int[a + 1];

        if (tileList.length == 2) {
            System.out.println("1");
            return;
        }
        if (tileList.length == 3) {
            System.out.println("2");
            return;
        }

        tileList[1] = 1;
        tileList[2] = 2;

        for (int i = 3; i <= a; i++) {
            int a2 = tileList[i - 1] + tileList[i - 2];
            if ((tileList[i - 1] + tileList[i - 2]) / 10_007 > 0) {
                a2 = (tileList[i - 1] + tileList[i - 2]) % 10_007;
            }
            tileList[i] = a2;
        }

        System.out.println(tileList[tileList.length-1]);

    }
}

