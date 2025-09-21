import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();

        String[] split = String.valueOf(a).split("");
        List<Integer> dataLL = new ArrayList<>();

        long sum = 0;

        for (String s : split) {
            int i = Integer.parseInt(s);
            sum += i;
            dataLL.add(i);
        }

        if (!Arrays.asList(split).contains("0") || sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        dataLL.sort(Collections.reverseOrder());

        for (Integer i : dataLL) {
            System.out.print(i);
        }

    }
}
