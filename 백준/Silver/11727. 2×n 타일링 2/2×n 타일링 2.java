import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] titleList = new int[a + 1];
        if (a == 1) {
            System.out.println("1");
            return;
        }

        if (a == 2) {
            System.out.println("3");
            return;
        }

        titleList[1] = 1;
        titleList[2] = 3;


        for (int i = 3; i <= a; i++) {
            int t = titleList[i - 1] + titleList[i - 2] + titleList[i - 2];
            titleList[i] = t % 10_007;
        }
        System.out.println(titleList[titleList.length-1]);
    }
}

