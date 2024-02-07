import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int size = in.nextInt();
            int count = 1;
            int start = 0;
            int end = 0;
            int sum = 1;
            int[] dataList = new int[size];
            for (int i = 0; i < size; i++) {
                dataList[i] = i + 1;
            }

            while (end < size - 1) {
                if (sum < size) {
                    end++;
                    sum += dataList[end];
                } else if (sum > size) {
                    sum -= dataList[start];
                    start++;
                } else {
                    end++;
                    sum += dataList[end];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
