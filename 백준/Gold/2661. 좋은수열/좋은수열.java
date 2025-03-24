import java.util.Scanner;

/**
 * 문제 :: 좋은 수열
 * 등급 :: 골드 4
 * 알고리즘 :: 백트래킹
 * 문제 내용 :: 숫자 1,2,3으로 이루어져 있는데 두개의 부분이 동일한 수열로 이루여저 있으면 나쁜 수열, 안이루어져 있으면 좋은 수열
 * 입력 값 :: N하나로 이루어진 숫자 [ 7 ]
 * 반환 값 :: 길이가 N인 좋은 수열들 중에서 가장 작은 수를 나타내는 수열만 출력
 */
public class Main {

    static int[] numbers = {
            1, 2, 3
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        backtracking(number, 0, sb);

    }

    public static void backtracking(int number, int startNumber, StringBuilder result) {
        if (startNumber >= number) {
            System.out.println(result);
            System.exit(0);
        }
        for (int number1 : numbers) {
            result.append(number1);
            if (!checkNumber2(result)) {
                backtracking(number, startNumber + 1, result);
            }
            result.deleteCharAt(result.length() - 1);
        }
    }

    public static boolean checkNumber2(StringBuilder result) {
        int length = result.length();

        for (int k = 1; k <= length / 2; k++) {
            String left = result.substring(length - 2 * k, length - k);
            String right = result.substring(length - k);
            if (left.equals(right)) {
                return true;
            }
        }
        return false;
    }
}
