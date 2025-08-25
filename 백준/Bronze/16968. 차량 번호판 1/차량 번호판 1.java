import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int NUMBER = 10;
    private static int EN = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] split = s.split("");
        recursion(0, split, "NONE", 0);

    }

    public static void recursion(int start, String[] split, String beforeData, int sum) {
        if (start == split.length) {
            System.out.println(sum);
            return;
        }
        String getData = split[start];
        sum = caculator(getData, beforeData, sum);

        recursion(start + 1, split, getData, sum);
    }

    public static int caculator(String getData, String beforeData, int sum) {
        if(sum == 0 )
            sum = 1;

        if ("d".equals(getData)) {
            if (getData.equals(beforeData)) {
                sum *= (NUMBER - 1);
                return sum;
            }
            NUMBER = 10;
            sum *= NUMBER;
        } else {
            if (getData.equals(beforeData)) {
                sum *= (EN - 1);
                return sum;
            }
            EN = 26;
            sum *= EN;
        }
        return sum;
    }
}
