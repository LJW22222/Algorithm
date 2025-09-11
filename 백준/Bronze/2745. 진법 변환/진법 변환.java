import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        String a = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        System.out.println(Integer.parseInt(a, b));
    }
}
