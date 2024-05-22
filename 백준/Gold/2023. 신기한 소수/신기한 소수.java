import java.util.Scanner;

public class Main{

    static int A;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        A = in.nextInt();
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

    }
    static void DFS(int n, int a) {
        if (a >= A) {
                System.out.println(n);
            return;
        }

        for (int i = 1; i < 10; i++) {

            if (i % 2 != 0) {
                int i1 = n * 10 + i;
                if(prime(i1))
                    DFS(i1, a+1);
            }
        }
    }

    static boolean prime(int n) {
        boolean bo = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                bo = false;
                break;
            }
        }
        return bo;
    }
}
