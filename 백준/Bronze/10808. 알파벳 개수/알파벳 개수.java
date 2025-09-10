import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        int[] countList = new int[26];
        for (char c : charArray) {
            int c1 = (int)c - 97;
            countList[c1] += 1;
        }

        for (int i : countList) {
            System.out.print(i + " ");
        }
    }
}