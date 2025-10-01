import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] dpTable = new int[number + 1];

        dpTable[0] = 0;
        dpTable[1] = 1;

        for (int i = 1; i < number + 1; i++) {
            double sqrt = Math.sqrt(i);
            if ((int)sqrt * (int)sqrt == i) {
                dpTable[i] = 1;
                continue;
            }
            int a = 1;
            int z;
            int resultN = 100_000;
            while (true) {
                z = a * a;
                if (z > i) {
                    break;
                }
                resultN = Math.min(dpTable[i - z] + 1, resultN);
                a += 1;

            }
            dpTable[i] = resultN;
        }


        System.out.println(dpTable[dpTable.length-1]);

    }
}

