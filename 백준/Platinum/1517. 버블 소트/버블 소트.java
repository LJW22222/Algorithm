import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] tt;
    static Long count = 0L;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] dataList = new int[Integer.parseInt(st.nextToken())];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < dataList.length; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort1(dataList,  dataList.length-1);
        System.out.println(count);

    }

    static void mergeSort1(int a[], int n) {
        tt = new int[n];
        MergeSort(a, 0, n);
        tt = null;
    }

    static void MergeSort(int a[], int Lp, int Rp) {
        if(Lp < Rp) {
            int centor = (Rp + Lp) / 2;

            int i;
            int p = 0;

            int j = 0;
            int k = Lp;

            MergeSort(a, Lp, centor);
            MergeSort(a, centor + 1, Rp);

            for (i = Lp; i <= centor; i++) {
                tt[p++] = a[i];
            }
            while (i <= Rp && j < p) {
                if (tt[j] <= a[i]) {
                    a[k++] = tt[j++];
                } else {
                    a[k++] = a[i++];
                    count += i - k;
                }
            }

            while (j < p) {
                a[k++] = tt[j++];
            }
        }
    }
}
