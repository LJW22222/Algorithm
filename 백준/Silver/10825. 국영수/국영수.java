import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        PriorityQueue<Student> dataList = new PriorityQueue<>((a, b ) -> {
            if(a.koScore == b.koScore && a.enScore == b.enScore && a.mathScore == b.mathScore){
                return a.name.compareTo(b.name);
            }
            if(a.koScore == b.koScore) {
                if (a.enScore == b.enScore) {
                    return b.mathScore - a.mathScore;
                }
                return a.enScore - b.enScore;
            }

            return b.koScore - a.koScore;
        });

        int i = Integer.parseInt(st.nextToken());
        for (int j = 0; j < i; j++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int koScore = Integer.parseInt(st.nextToken());
            int enScore = Integer.parseInt(st.nextToken());
            int mathScore =Integer.parseInt(st.nextToken());

            dataList.add(new Student(name, koScore, enScore, mathScore));
        }

        while (!dataList.isEmpty()) {
            Student poll = dataList.poll();
            System.out.println(poll.name);
        }

    }

    private static class Student {
        String name;
        int koScore;
        int enScore;
        int mathScore;

        public Student(String name, int koScore, int enScore, int mathScore) {
            this.name = name;
            this.koScore = koScore;
            this.enScore = enScore;
            this.mathScore = mathScore;
        }
    }
}
