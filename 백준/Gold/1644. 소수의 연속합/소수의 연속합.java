import java.io.*;
import java.util.Arrays;

public class Main {

    private static boolean[] decimalList;

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        decimalList = new boolean[number + 1];
        Arrays.fill(decimalList, true);
        decimalList[1] = false;
        decimalList[0] = false;

        getDecimal(number);
        toPoint(number);

    }

    private static void toPoint(int number) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (left <= right) {
            if (sum < number) {
                if (right > number) {
                    break;
                }

                if (decimalList[right]) {
                    sum += right;
                }
                right +=1;

            } else {
                if (left > number) {
                    break;
                }

                if (decimalList[left]) {
                    if (number == sum) {
                        count += 1;
                    }
                    sum -= left;
                }
                left +=1;
            }
        }
        System.out.println(count);

    }

    private static void getDecimal(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (!decimalList[i]) continue;
            for (int j = i * i; j <= number; j += i) {
                decimalList[j] = false;
            }
        }
    }
}
