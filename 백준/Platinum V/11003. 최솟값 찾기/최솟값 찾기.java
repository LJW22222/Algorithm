import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());

        Deque<Node> dequeList = new LinkedList<>();
        for (int i = 0; i < A; i++) {
            int i1 = Integer.parseInt(st.nextToken());
            if(!dequeList.isEmpty()) {
                while (dequeList.getLast().value > i1) {
                    dequeList.removeLast();
                    if (dequeList.isEmpty()) {
                        break;
                    }
                }
            }
            dequeList.addLast(new Node(i1, i));

            if (dequeList.getLast().index - B >= dequeList.getFirst().index) {
                    dequeList.removeFirst();
                }

            out.write(dequeList.getFirst().value + " ");
        }
    out.flush();
    }

    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
