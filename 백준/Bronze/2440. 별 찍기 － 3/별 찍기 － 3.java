import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String s = "*";
        for (int j = i; j > 0; j--) {
            System.out.println(s.repeat(j));
        }
    }
}
