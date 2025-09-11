import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        String a = st.nextToken();
        String string = new BigInteger(a, 8).toString(2);
        System.out.println(string);
    }
}
