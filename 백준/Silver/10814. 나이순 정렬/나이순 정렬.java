import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        PriorityQueue<Human> dataList = new PriorityQueue<>((a, b ) -> {
            if(a.age == b.age) return a.signUpDate - b.signUpDate;
            return a.age - b.age;
        });
        int i1 = Integer.parseInt(st.nextToken());
        int day = 1;
        for (int i = 0; i < i1; i++) {
            st = new StringTokenizer(bf.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            dataList.add(new Human(age, name, day));
            day++;
        }

        while (!dataList.isEmpty()) {
            Human poll = dataList.poll();
            System.out.println(poll.age + " " + poll.name);
        }

    }

    private static class Human {
        int age;
        String name;
        int signUpDate;

        public Human(int age, String name, int signUpDate) {
            this.age = age;
            this.name = name;
            this.signUpDate = signUpDate;
        }
    }
}
