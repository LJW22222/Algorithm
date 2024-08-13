import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] z1;

    public static void main(String[] args) throws IOException {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bu.readLine());

        int i1 = Integer.parseInt(st.nextToken());
        z1 = new int[i1];
        st = new StringTokenizer(bu.readLine());
        for (int i = 0; i < i1; i++) {
            z1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bu.readLine());
        
        int i2 = Integer.parseInt(st.nextToken());
        int[] z2 = new int[i2];
        st = new StringTokenizer(bu.readLine());
        for (int i = 0; i < i2; i++) {
            z2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(z1);

        for (int j : z2) {
            if (binarySearch(j, z1.length - 1) >= 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }


    }

    static int binarySearch(int searchingNumber, int right) {
        int mid;
        int left = 0;
        while (left <= right) {
            mid = (left+right) / 2;
            if(searchingNumber == z1[mid]){
                return mid;
            } else if (searchingNumber < z1[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
