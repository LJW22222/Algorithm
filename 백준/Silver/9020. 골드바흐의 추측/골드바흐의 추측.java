import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader ad = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(ad.readLine());
		int w[] = new int[a];

		for (int i = 0; i < a; i++) {
			w[i] = Integer.parseInt(ad.readLine());
		}
		for (int i = 0; i < a; i++) {
			int result = 0;
			int j1 = w[i] / 2;
			int j2 = j1;
			int cc[] = new int[w[i] + 1];
			cc[0] = 1;
			cc[1] = 1;
			for (int w1 = 2; w1 * w1 <= w[i]; w1++) {
				if (cc[w1] == 0) {
					for (int j = w1 * w1; j <= w[i]; j += w1) {
						cc[j] = 1;
					}
				}
			}
			while (true) {
				if (cc[j1] == 0 && cc[j2] == 0) {
					result = j1 + j2;
					if(result == w[i]) {
						System.out.println(j1 + " " + j2);
						break;
					}else if(result > w[i]) {
						j1--;
					}else if(result < w[i]) {
						j2++;
					}
				}else if(cc[j1] != 0) {
					j1--;
				}else if(cc[j2] != 0) {
					j2++;
				}
			}
		}
	}
}