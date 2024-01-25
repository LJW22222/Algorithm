import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int B = in.nextInt();
		int N = in.nextInt();      
		for(int i = B; i <= N; i++) {
			make_prime(i);
		}
    
	}
	public static void make_prime(int number) {
		if(number < 2) {
			return;
		}
		if(number == 2) {
			System.out.println(number);
			return;
		}
		for(int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0) {
				return;
			}
		}
		System.out.println(number);
		return;
	}
}