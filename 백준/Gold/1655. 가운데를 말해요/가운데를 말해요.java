import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> heapRight = new PriorityQueue<>();
        PriorityQueue<Integer> heapLeft = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int number = Integer.parseInt(st.nextToken());

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(bf.readLine());
            int dataNumber = Integer.parseInt(st.nextToken());
            insertData(heapRight, heapLeft, dataNumber, sb);
        }
        printStringBuilder(sb);
    }

    private static void insertData(PriorityQueue<Integer> heapRight, PriorityQueue<Integer> heapLeft, Integer dataNumber, StringBuilder sb) {
        if (heapLeft.isEmpty() || heapLeft.peek() >= dataNumber) {
            heapLeft.add(dataNumber);
        } else {
            heapRight.add(dataNumber);
        }

        if (heapLeft.size() < heapRight.size()) {
            Integer poll = heapRight.poll();
            heapLeft.add(poll);
        } else if (heapLeft.size() > heapRight.size() + 1) {
            Integer poll = heapLeft.poll();
            heapRight.add(poll);
        }

        if (!heapLeft.isEmpty() && !heapRight.isEmpty() && heapLeft.peek() > heapRight.peek()) {
            Integer poll = heapLeft.poll();
            Integer poll1 = heapRight.poll();
            heapLeft.add(poll1);
            heapRight.add(poll);
        }

        sb.append(heapLeft.peek()).append("\n");
    }

    private static void printStringBuilder(StringBuilder stringBuilder) {
        System.out.println(stringBuilder.toString());
    }

}
