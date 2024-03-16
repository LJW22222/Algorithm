import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int A = Integer.parseInt(st.nextToken());
        sort[] dataList = new sort[A];
        int[] numberlist = new int[A];
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(in.readLine());
            dataList[i] = new sort(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(dataList);
        for (int i = 0; i < A; i++) {
            numberlist[i] = dataList[i].index - i;
        }
        Arrays.sort(numberlist);
        System.out.println(numberlist[A-1]+1);

    }
}

class sort implements Comparable<sort>{
    int value;
    int index;

    public sort(int index, int value) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(sort o) {
        return this.value - o.value;
    }
}
