import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String split = in.readLine();
        String boom = in.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : split.toCharArray()) {
            sb.append(c);
            if (sb.length() >= boom.length() && sb.substring(sb.length() - boom.length()).equals(boom)) {
                sb.setLength(sb.length() - boom.length());
            }
        }
        if (sb.length() == 0) {
            out.write("FRULA");
        } else {
            out.write(sb.toString());
        }
        out.flush();
    }
}
