import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int i;
    static int[][] dataList;

    static boolean[] visitedList;

    static ArrayList<Integer> resultLtList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        i = Integer.parseInt(st.nextToken());
        dataList = new int[i][i];
        for (int j = 0; j < i; j++) {
            st = new StringTokenizer(br.readLine());
            for (int z = 0; z < i; z++) {
                dataList[j][z] = Integer.parseInt(st.nextToken());
            }
        }
        visitedList = new boolean[i];
        resultLtList = new ArrayList<>();
        BackTraking(0, i/2);
        System.out.println(Collections.min(resultLtList));
    }

    static void BackTraking(int start, int result) {

        if (result == 0) {
            int startsum = 0;
            int rinksum = 0;
            for (int i = 0; i < visitedList.length; i++) {
                for (int j = i; j < visitedList.length; j++) {
                    if (visitedList[i] && visitedList[j]) {
                        startsum += dataList[i][j] + dataList[j][i];
                    }
                    if(!visitedList[i] && !visitedList[j]){
                        rinksum += dataList[i][j] + dataList[j][i];
                    }
                }
            }
            if (startsum > rinksum) {
                resultLtList.add(startsum - rinksum);
            } else {
                resultLtList.add(rinksum - startsum);
            }
            return;
        }
        for(int j = start; j < i; j++) {
            visitedList[j] = true;
            BackTraking(j+1,result-1);
            visitedList[j] = false;
        }
    }

}
