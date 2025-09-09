import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();
        for (int i = 0; i < next; i++) {
            String input = sc.next();
            String[] split = input.split(",");
            sb.append(Integer.parseInt(split[0]) + Integer.parseInt(split[1])).append("\n");
        }
        System.out.println(sb.toString());
    }
}
