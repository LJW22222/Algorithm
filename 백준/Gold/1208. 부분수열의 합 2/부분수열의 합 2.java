import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] dataList;
    private static int resultNumber;
    private static int A;

    private static ArrayList<Long> leftDataList;
    private static ArrayList<Long> rightDataList;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        resultNumber = Integer.parseInt(st.nextToken());

        dataList = new int[A];
        leftDataList = new ArrayList<>();
        rightDataList = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < A; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }


        visited = new boolean[A / 2 + 1];
        MITM_DFS(0, A / 2, 1);
        visited = new boolean[A];
        MITM_DFS(A / 2, A, 0);

        rightDataList.sort(Comparator.naturalOrder());
        leftDataList.sort(Comparator.naturalOrder());


        TwoPointer();
    }

    private static void TwoPointer() {
        int left = 0;
        int right = rightDataList.size() - 1;
        long count = 0;

        while (left < leftDataList.size() && right >= 0) {
            long sum = leftDataList.get(left) + rightDataList.get(right);

            if (sum < resultNumber) {
                left += 1;
            } else if (sum > resultNumber) {
                right -= 1;

            } else {
                long a = duplicationCheck(left, leftDataList.get(left), 0, leftDataList.size());
                left += (int) a;
                long b = duplicationCheck(right, rightDataList.get(right), 1, 0);
                right -= (int) b;
                count += a * b;
            }
        }

        if (resultNumber == 0) {
            count -= 1;
        }
        System.out.println(count);
    }

    private static long duplicationCheck(int number, long result, int type, int end) {
        long plusNumber = number;
        long count = 0;

        if (type == 0) {
            while (plusNumber < end) {
                if (leftDataList.get((int) plusNumber) == result) {
                    plusNumber += 1;
                    count += 1;
                } else {
                    break;
                }
            }
        } else {
            while (plusNumber >= 0) {
                if (rightDataList.get((int) plusNumber) == result) {
                    plusNumber -= 1;
                    count += 1;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    private static void MITM_DFS(int i, int end, int listType) {
        if (i == end) {
            long sum = 0;
            for (int a = 0; a < i; a++) {
                if (visited[a]) {
                    sum += dataList[a];
                }
            }

            if (listType == 1) {
                leftDataList.add(sum);
            } else {
                rightDataList.add(sum);
            }
            return;
        }

        visited[i] = false;
        MITM_DFS(i + 1, end, listType);
        visited[i] = true;
        MITM_DFS(i + 1, end, listType);


    }


}
