import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();
        int sSize = s.length();
        int ss = 0;
        while (ss <= sSize) {
            if (ss + 10 <= sSize) {
                System.out.println(s.substring(ss, ss+10));
            }else {
                System.out.println(s.substring(ss));
            }


            ss += 10;
        }
    }
}
