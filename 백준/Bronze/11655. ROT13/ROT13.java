import java.io.IOException;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            char[] charArray = s.toCharArray();

            for (char c : charArray) {
                if ((65 <= (int) c) && ((int) c <= 90)) {
                    int i = (int) c + 13;
                    if (i > 90) {
                        System.out.print((char) (i - 26));
                        continue;
                    }
                    System.out.print((char)i);
                    continue;
                } else if ((97 <= (int) c) && ((int) c <= 122)) {
                    int i = (int) c + 13;
                    if (i > 122) {
                        System.out.print((char)(i - 26));
                        continue;
                    }
                    System.out.print((char)i);
                    continue;
                }
                System.out.print(c);
            }
        }
    }
