import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dataList;
    static List<int[]> ckDataList;

    static List<int[]> homeList;

    static boolean[] vi;
    static ArrayList<Integer> itotalvisited;
    static int M;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()) + 2;
        N = Integer.parseInt(st.nextToken());

        dataList = new int[M][M];
        ckDataList = new ArrayList<>();

        homeList = new ArrayList<>();

        for (int j = 1; j < M - 1; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int z = 1; z < M - 1; z++) {
                int i = Integer.parseInt(st.nextToken());
                if (i == 2) {
                    ckDataList.add(new int[]{j, z});
                }
                if (i == 1) {
                    homeList.add(new int[]{j, z});
                }
                dataList[j][z] = i;
            }
        }

        vi = new boolean[ckDataList.size()];
        itotalvisited = new ArrayList<>();
        BackTracking(0, N);
        System.out.println(Collections.min(itotalvisited));
    }

    static void BackTracking(int z, int N1) {
        if (N1 == 0) {
            int result = 0;
            for (int[] ints : homeList) {
                int min = 0;
                for (int i = 0; i < vi.length; i++) {
                    if (vi[i]) {
                        int i2 = Math.abs(ckDataList.get(i)[0] - ints[0]) + Math.abs(ckDataList.get(i)[1] - ints[1]);
                        if (min == 0) {
                            min = i2;
                        } else if (min > i2) {
                            min = i2;
                        }
                    }
                }
                result += min;
            }
            itotalvisited.add(result);
            return;
        }
        for (int i = z; i < ckDataList.size(); i++) {
            if (!vi[i]) {
                vi[i] = true;
                BackTracking(i + 1, N1 - 1);
                vi[i] = false;
            }
        }

    }

}
