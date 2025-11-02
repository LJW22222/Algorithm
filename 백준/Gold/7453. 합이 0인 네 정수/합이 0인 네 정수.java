import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int sizeNumber;


    private static int[] Alist;
    private static int[] Blist;
    private static int[] Clist;
    private static int[] Dlist;

    private static int[] ABlist;
    private static int[] CDlist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sizeNumber = Integer.parseInt(st.nextToken());

        Alist = new int[sizeNumber];
        Blist = new int[sizeNumber];
        Clist = new int[sizeNumber];
        Dlist = new int[sizeNumber];

        for (int i = 0; i < sizeNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            Alist[i] = number;

            number = Integer.parseInt(st.nextToken());
            Blist[i] = number;

            number = Integer.parseInt(st.nextToken());
            Clist[i] = number;

            number = Integer.parseInt(st.nextToken());
            Dlist[i] = number;
        }

        ABlist = new int[sizeNumber * sizeNumber];
        CDlist = new int[sizeNumber * sizeNumber];

        caculatorSet(Alist, Blist, ABlist);
        caculatorSet(Clist, Dlist, CDlist);

        Arrays.sort(ABlist);
        Arrays.sort(CDlist);

        toPointer();
    }

    private static void toPointer() {
        int left = 0;
        int right = CDlist.length - 1;
        long count = 0;


        while (left < sizeNumber * sizeNumber && right >= 0) {
            long sum = ABlist[left] + CDlist[right];

            if (sum == 0) {
                long ABPlusNUmber = ABlistDuplicateBlock(ABlist[left], left);
                long CDPlusNUmber = CDlistDuplicateBlock(CDlist[right], right);
                count += ABPlusNUmber * CDPlusNUmber;
                left += (int) ABPlusNUmber;
                right -= (int) CDPlusNUmber;
                continue;
            }

            if (sum < 0) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        System.out.println(count);
    }

    private static long ABlistDuplicateBlock(long number, int left) {
        long count = 1;
        for (int i = left + 1; i < ABlist.length; i++) {
            if (ABlist[i] == number) {
                count += 1;
            } else {
                break;
            }
        }
        return count;
    }

    private static long CDlistDuplicateBlock(long number, int right) {
        long count = 1;
        for (int i = right - 1; i >= 0; i--) {
            if (CDlist[i] == number) {
                count += 1;
            } else {
                break;
            }
        }
        return count;
    }

    private static void caculatorSet(int[] oneList, int[] twoList, int[] resultList) {
        int a = 0;
        for (int i = 0; i < sizeNumber; i++) {
            for (int j = 0; j < sizeNumber; j++) {
                resultList[a] = oneList[i] + twoList[j];
                a++;
            }
        }
    }
}
