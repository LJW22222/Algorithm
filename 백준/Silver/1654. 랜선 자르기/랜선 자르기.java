import java.io.*;
import java.util.*;

public class Main {

    private static Integer[] dataList;
    private static int resultCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        resultCount = Integer.parseInt(st.nextToken());

        dataList = new Integer[number];

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            dataList[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(dataList, Comparator.reverseOrder());
        checkRAN();


    }

    private static void checkRAN() {
        long left = 1;
        long right = dataList[0];
        long mid;

        long ans = 0;
        long sum;

        while (left <= right) {
            sum = 0;
            mid = (left + right) / 2;

            for (Integer i : dataList) {
                sum += i / mid;
            }

            if (sum < resultCount) {
                right = mid - 1;

            }else if (sum >= resultCount) {
                left = mid + 1;
                ans = mid;
            }

        }
        System.out.println(ans);
    }
}
