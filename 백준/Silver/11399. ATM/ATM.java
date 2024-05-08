
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //3 1 4 3 2
        //1 2 3 4 5
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        List<Peple> box = new ArrayList<>();
        int sum = 0;
        int result = 0;
        for (int i = 0; i < A; i++) {
            int peplee = Integer.parseInt(st.nextToken());
            box.add(new Peple(i+1, peplee));

        }
        box.sort(new sortedPeple());
        for (Peple peple : box) {
            sum += peple.time;
            result += sum;
        }
        System.out.println(result);
    }
    public static class Peple {
        int number;
        int time;

        public Peple(int number, int time) {
            this.number = number;
            this.time = time;
        }
    }

    public static class sortedPeple implements Comparator<Peple> {

        @Override
        public int compare(Peple o1, Peple o2) {
            if (o1.time == o2.time) {
                return o1.number - o2.number;
            }else {
                return o1.time - o2.time;
            }
        }
    }
}

