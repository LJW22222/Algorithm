
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][] lines = {
            //가로
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            //세로
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            //대각선
            {0, 4, 8}, {2, 4, 6},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        while (!input.equals("end")) {
            char[] charArray = input.toCharArray();


            int xSum = 0;
            int oSum = 0;
            int jumSum = 0;
            for (char c : charArray) {
                if (c == 'X') {
                    xSum += 1;
                }
                if (c == 'O') {
                    oSum += 1;
                }
                if (c == '.') {
                    jumSum += 1;
                }
            }

            //
            boolean xWin = checking('X', charArray);
            boolean oWin = checking('O', charArray);


            //
            if (
                    (!oWin && !xWin && oSum > xSum) ||
                    (!oWin && !xWin && jumSum > 0) ||
                            (oWin && xSum != oSum) ||
                            (xWin && xSum - oSum != 1)
            ) {
                System.out.println("invalid");
            } else {
                System.out.println("valid");
            }


            st = new StringTokenizer(br.readLine());
            input = st.nextToken();
        }

    }

    //    OOX
//    XXO
//    OXO
// XOXOXOXOX
    private static boolean winNextNumberChecking(char c, char[] charArray, int xSum, int oSum) {

        for (int[] line : lines) {
            if (charArray[line[0]] == c && charArray[line[1]] == c && charArray[line[2]] == c) {
                if (c == 'O') {

                } else {

                }
            }
        }
        return true;
    }

    private static boolean checking(char c, char[] charArray) {

        for (int[] line : lines) {
            if (charArray[line[0]] == c && charArray[line[1]] == c && charArray[line[2]] == c) {
                return true;
            }
        }
        return false;
    }

}
