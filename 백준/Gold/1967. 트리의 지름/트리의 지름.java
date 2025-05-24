import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int sumRoute = 0;
    static int number2 = 0;
    static final Map<Integer, ArrayList<Node>> dataList = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int number = Integer.parseInt(st.nextToken());
        for (int i = 0; i < number - 1; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (dataList.containsKey(a)) {
                ArrayList<Node> nodes = dataList.get(a);
                nodes.add(new Node(b, c));
                dataList.put(a, nodes);
            }else {
                ArrayList<Node> nodes = new ArrayList<>();
                nodes.add(new Node(b, c));
                dataList.put(a, nodes);
            }
            if (dataList.containsKey(b)) {
                ArrayList<Node> nodes = dataList.get(b);
                nodes.add(new Node(a, c));
                dataList.put(b, nodes);
            }else {
                ArrayList<Node> nodes = new ArrayList<>();
                nodes.add(new Node(a, c));
                dataList.put(b, nodes);
            }
        }
        visited = new boolean[number+1];
        DFS(1, 0);
        sumRoute = 0;
        visited = new boolean[number+1];
        DFS(number2, 0);
        System.out.println(sumRoute);
    }

    private static void DFS(int startNumber, int sum){
        visited[startNumber] = true;
        ArrayList<Node> nodes = dataList.getOrDefault(startNumber, new ArrayList<>());
        for (Node node : nodes) {
            if (!visited[node.vicinityNode]) {
                DFS(node.vicinityNode, sum + node.point);
            }
        }
        if (sumRoute < sum) {
            sumRoute = sum;
            number2 = startNumber;
        }
    }

    private static class Node {
        int vicinityNode;
        int point;

        public Node(int vicinityNode, int point) {
            this.vicinityNode = vicinityNode;
            this.point = point;
        }
    }
}
