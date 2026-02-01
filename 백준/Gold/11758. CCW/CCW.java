import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Node> dataList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dataList.add(new Node(x, y));

        }

        checkOne(dataList);


    }

    public static void checkOne(ArrayList<Node> dataList) {
        Node one = dataList.get(0);
        Node two = dataList.get(1);
        Node three = dataList.get(2);

        int result = (two.x - one.x) * (three.y - one.y) - (two.y - one.y) * (three.x - one.x);

        if (result > 0) {
            System.out.println(1);
        } else if (result < 0) {
            System.out.println("-1");
        } else {
            System.out.println(0);
        }
    }



    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
