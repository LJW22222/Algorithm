import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String s = "*";
        String d = " ";
        for (int j = 1; j <= i; j++) {
            String repeat1 = s.repeat(j * 2 - 1);
            String repeat = d.repeat(i-j);
            System.out.println(repeat + repeat1);
        }
    }
}