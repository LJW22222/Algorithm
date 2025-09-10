import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

    public class Main {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            String d = st.nextToken();
            String ab = a + b;
            String cd = c + d;
            System.out.println(Long.parseLong(ab) + Long.parseLong(cd));
        }
    }
