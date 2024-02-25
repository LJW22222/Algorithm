
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        Queue<Integer> qlist = new LinkedList<>();
        for (int z = 1; z <= i; z++) {
            qlist.add(z);
        }
        while (qlist.size() > 1) {
            qlist.remove();
            Integer peek = qlist.peek();
            qlist.add(peek);
            qlist.remove();
        }
        System.out.println(qlist.peek());
    }
}
