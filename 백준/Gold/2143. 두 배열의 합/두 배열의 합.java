import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] Alist;
    private static int[] Blist;

    private static int[] ASumList;
    private static int[] BSumList;

    private static ArrayList<Long> ASumTotalList = new ArrayList<>();
    private static ArrayList<Long> BSumTotalList = new ArrayList<>();


    private static int number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        number = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int listSize = Integer.parseInt(st.nextToken());
        Alist = inputDataToList(listSize, new StringTokenizer(br.readLine()));

        ASumList = new int[listSize + 1];
        makePrefix(ASumList, Alist);

        st = new StringTokenizer(br.readLine());
        listSize = Integer.parseInt(st.nextToken());
        Blist = inputDataToList(listSize, new StringTokenizer(br.readLine()));

        BSumList = new int[listSize + 1];
        makePrefix(BSumList, Blist);


        makeSubTotal(ASumList, ASumTotalList);
        makeSubTotal(BSumList, BSumTotalList);

        Collections.sort(ASumTotalList);
        Collections.sort(BSumTotalList);

        twoPointer();

    }

    private static void makePrefix(int[] resultDataList, int[] dataList) {
        for (int i = 0; i < dataList.length; i++) {
            resultDataList[i + 1] = dataList[i] + resultDataList[i];
        }
    }

    private static void makeSubTotal(int[] dataList, ArrayList<Long> resultDataList) {
        for (int i = 0; i < dataList.length; i++) {
            for (int j = i+1; j < dataList.length; j++) {
                resultDataList.add((long) (dataList[j] - dataList[i]));
            }
        }
    }

    private static void twoPointer() {

        long left = 0;
        long right = BSumTotalList.size() - 1;
        long sum;
        long result = 0;

        while (left < ASumTotalList.size() && right >= 0) {
            sum = ASumTotalList.get((int) left) + BSumTotalList.get((int) right);
            if (sum == number) {
                long plusLeft = leftDuplicateBlock((int) left);

                long plusRight = rightDuplicateBlock((int) right);

                left += plusLeft;
                right -= plusRight;

                result += plusLeft * plusRight;
            } else if (sum < number) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        System.out.println(result);
    }

    private static long leftDuplicateBlock(int left) {
        Long R = ASumTotalList.get(left);
        long count = 0;
        for (int i = left; i < ASumTotalList.size(); i++) {
            if (R.equals(ASumTotalList.get(i))) {
                count += 1;
            } else {
                break;
            }
        }
        return count;
    }

    private static long rightDuplicateBlock(int right) {
        Long R = BSumTotalList.get(right);
        long count = 0;
        for (int i = right; i >= 0; i--) {
            if (R.equals(BSumTotalList.get(i))) {
                count += 1;
            } else {
                break;
            }
        }
        return count;
    }

    private static int[] inputDataToList(int listSize, StringTokenizer input) {
        int[] resultDataList = new int[listSize];

        for (int i = 0; i < listSize; i++) {
            int number = Integer.parseInt(input.nextToken());
            resultDataList[i] = number;
        }
        return resultDataList;
    }
}
