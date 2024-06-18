import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int A;
    static int B;

    static int[][] dataList;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dataList = new int[B][A];
        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < A; j++) {
                dataList[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
        for (int[] ints : dataList) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    count = -1;
                    break;
                }
            }
        }
        if (count != -1) {
            count -= 1;
        }
        System.out.println(count);
    }

    static void BFS() {
        Queue<tomato> tomatoList = new LinkedList<>();
        for (int i = 0; i < B; i++) {
            for (int j = 0; j < A; j++) {
                if (dataList[i][j] == 1) {
                    tomatoList.add(new tomato(i, j, 0));
                }
            }
        }
        int days = 0;
        while (!tomatoList.isEmpty()) {
            tomato poll = tomatoList.poll();
            days = poll.day+1;
            if (poll.aA - 1 >= 0 && dataList[poll.aA - 1][poll.bB] == 0) {
                tomatoList.add(new tomato(poll.aA - 1, poll.bB, days));
                dataList[poll.aA - 1][poll.bB] = 1;
            }
            if (poll.bB - 1 >= 0 && dataList[poll.aA][poll.bB - 1] == 0) {
                tomatoList.add(new tomato(poll.aA, poll.bB - 1, days));
                dataList[poll.aA][poll.bB - 1] = 1;
            }
            if (poll.aA + 1 < B && dataList[poll.aA + 1][poll.bB] == 0) {
                tomatoList.add(new tomato(poll.aA + 1, poll.bB, days));
                dataList[poll.aA + 1][poll.bB] = 1;
            }
            if (poll.bB + 1 < A && dataList[poll.aA][poll.bB + 1] == 0) {
                tomatoList.add(new tomato(poll.aA, poll.bB + 1, days));
                dataList[poll.aA][poll.bB + 1] = 1;
            }
            count = days;
        }
    }

    static class tomato {
        int aA;
        int bB;

        int day;

        public tomato(int aA, int bB, int day) {
            this.aA = aA;
            this.bB = bB;
            this.day = day;
        }
    }

}
