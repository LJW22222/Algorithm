import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader ad = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter ab = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(ad.readLine());
		int b[] = new int[a];
		for(int i = 0; i < a; i++) {
			int c = Integer.parseInt(ad.readLine());
			b[i] = c;
		}
		Arrays.sort(b);
		for(int i = 0; i < a; i++) {
			ab.write(b[i]+"");
			ab.newLine();
		}
		ab.flush();
		ab.close();
	}
}