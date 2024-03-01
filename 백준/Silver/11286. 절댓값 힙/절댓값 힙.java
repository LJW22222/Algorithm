
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<sorted> qlist;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        qlist = new PriorityQueue<>();
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(st.nextToken());
            if (c == 0) {
                if (!qlist.isEmpty()) {
                    sorted poll = qlist.poll();
                    System.out.println(poll.z);
                }else{
                    System.out.println("0");
                }
            }else{
                qlist.add(new sorted(c));
            }
        }
    }

    static class sorted implements Comparable<sorted> {
        int z;

        public sorted(int z) {
            this.z = z;
        }

        @Override
        public int compareTo(sorted o) {
            if (Math.abs(this.z) < Math.abs(o.z)) {
                return -1;
            }else if(Math.abs(this.z) > Math.abs(o.z)){
                return 1;
            }else{
                if (this.z < o.z) {
                    return -1;
                }else if (this.z > o.z) {
                    return 1;
                }
            }
            return 0;
        }
    }
}