import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int A;
    static int B;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        A = Integer.parseInt(in.next());
        // 출력 갯수
        B = Integer.parseInt(in.next());
        int[] nums = new int[A];
        for (int i = 0; i < A; i++) {
            nums[i] = i+1;
        }

        back_tracKing(nums, new ArrayList<>());

        System.out.println();
    }

    static void back_tracKing(int[] nums, ArrayList<Integer> integerArrayList ) {
        if (integerArrayList.size() == B) {
            for (Integer integer : integerArrayList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < A; i++) {
                if(integerArrayList.contains(nums[i]))
                    continue;
                integerArrayList.add(nums[i]);
                back_tracKing(nums, integerArrayList);
                integerArrayList.remove(integerArrayList.size()-1);
            }
        }

    }
}
