import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static ArrayList<Node>[] dataList;

    static int[] scoreList;
    static boolean[] visitied;

    static Queue<Integer> dfsList;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken())+1;
        dataList = new ArrayList[A];

        for (int i = 0; i < A; i++) {
            dataList[i] = new ArrayList<>();
        }
        for (int i = 1; i < A; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int i2 = Integer.parseInt(st.nextToken());
                if (i2 == -1) {
                    break;
                }
                int i3 = Integer.parseInt(st.nextToken());
                dataList[i1].add(new Node(i2,i3));
            }
        }
        scoreList = new int[A];
        visitied = new boolean[A];
        BFS(2);
        OptionalInt reduce = IntStream.range(0, scoreList.length)
                .reduce((i, j) -> scoreList[i] > scoreList[j] ? i : j);
        scoreList = new int[A];
        visitied = new boolean[A];
        BFS(reduce.getAsInt());
        int asInt = Arrays.stream(scoreList).max().getAsInt();
        System.out.println(asInt);
    }

    static void BFS(int a) {
        dfsList = new LinkedList<>();
        visitied[a] = true;
        for (Node node : dataList[a]) {
            visitied[node.getA()] = true;
            dfsList.add(node.getA());
            scoreList[node.getA()] = node.getB();
        }
        while (!dfsList.isEmpty()) {
            Integer poll = dfsList.poll();
            for (Node node : dataList[poll]) {
                if (!visitied[node.getA()]) {
                    dfsList.add(node.getA());
                    visitied[node.getA()] = true;
                    scoreList[node.getA()] = node.getB() + scoreList[poll];
                }
            }

        }

    }

    static class Node {
        int A;
        int B;

        public Node(int a, int b) {
            A = a;
            B = b;
        }

        public int getA() {
            return A;
        }

        public int getB() {
            return B;
        }
    }
}
