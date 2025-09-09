import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String s = "*";
        String d = " ";
        for (int j = i; j > 0; j--) {
            String repeat = d.repeat(i - j);
            String repeat1 = s.repeat(j);
            System.out.println(repeat + repeat1);
        }
    }
}