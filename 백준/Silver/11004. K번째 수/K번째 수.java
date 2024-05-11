
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] numberList = new int[Integer.parseInt(st.nextToken())];
        int checkNumber = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < numberList.length; i++) {
            numberList[i] = Integer.parseInt(st.nextToken());
        }
        QueckSort(numberList, 0, numberList.length-1);
        System.out.println(numberList[checkNumber-1]);
    }

    static void QueckSort(int[] numberList, int leftP, int rightP) {
        int pL = leftP;
        int pR = rightP;
        int pivot = numberList[(leftP + rightP) / 2];
        do {
            while (numberList[pL] < pivot) {
                pL++;
            }
            while (numberList[pR] > pivot) {
                pR--;
            }
            if (pL <= pR) {
                int t1 = pL++;
                int t2 = pR--;
                int t = numberList[t1];
                numberList[t1] = numberList[t2];
                numberList[t2] = t;
            }
        } while (pL <= pR);

        if (leftP < pR) {
            QueckSort(numberList, leftP, pR);
        }
        if (rightP > pL) {
            QueckSort(numberList, pL, rightP);
        }

    }
}
