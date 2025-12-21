import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static boolean[] nodeStatus;
    private static int number;
    private static List<double[]> dataList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        number = Integer.parseInt(st.nextToken());
        dataList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double A = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());

            dataList.add(new double[]{A, B});
        }


        nodeStatus = new boolean[number];

        double result = MST_Prim();

        System.out.printf("%.2f%n", result);

    }

    private static double MST_Prim() {
        int nodeNumber = 0;
        double constSum = 0;
        int count = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingDouble(a -> a.cost)
        );

        nodeStatus[0] = true;
        findNode(nodeNumber, queue);

        while (!queue.isEmpty()) {
            if (count >= number - 1) {
                break;
            }
            Node poll = queue.poll();
            if (nodeStatus[poll.end]) {
                continue;
            }
            nodeStatus[poll.end] = true;
            findNode(poll.end, queue);
            count += 1;
            constSum += poll.cost;
        }

        return constSum;
    }

    private static void findNode(int inputI, PriorityQueue<Node> queue) {
        double[] ilongs = dataList.get(inputI);
        double iaLong = ilongs[0];
        double ibLong = ilongs[1];
        for (int j = 0; j < dataList.size(); j++) {
            if (j == inputI) {
                continue;
            }
            if (nodeStatus[j]) {
                continue;
            }
            double[] jlongs = dataList.get(j);
            double jaLong = jlongs[0];
            double jbLong = jlongs[1];

            double absA = Math.abs(iaLong - jaLong);
            double absB = Math.abs(ibLong - jbLong);

            double sqrt = Math.sqrt(Math.pow(absA, 2) + Math.pow(absB, 2));
            queue.add(new Node(inputI, j, sqrt));
        }
    }


    private static class Node {
        int start;
        int end;
        double cost;

        public Node(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

    }
}
