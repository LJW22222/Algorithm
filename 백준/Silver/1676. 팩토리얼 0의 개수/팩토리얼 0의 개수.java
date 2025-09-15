import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        int number = 5;
        int sum = 0;
        while (i / number != 0) {
            sum += i / number;
            number *= 5;
        }
        System.out.println(sum);
    }
}
