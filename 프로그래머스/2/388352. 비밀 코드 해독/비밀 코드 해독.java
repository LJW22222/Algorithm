import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    public static int n1;
    public static int dataListSize;
    public static int[][] q1;
    public static int[] ans1;
    public static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        q1 = q;
        ans1 = ans;
        n1 = n;

        dataListSize = q1.length;

        makeNumberList(1, new ArrayList<>());

        return answer;
    }
        public static void makeNumberList(int start, List<Integer> selected) {
        if (selected.size() == q1[0].length) {
            checkCode(selected);
            return;
        }

        for (int i = start; i <= n1; i++) {
            selected.add(i);
            makeNumberList(i+1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    private static void checkCode(List<Integer> code) {
        for (int z = 0; z < dataListSize; z++) {
            int[] ints = q1[z];
            int count = 0;

            for (int anInt : ints) {
                if (code.contains(anInt)) {
                    count++;
                }
            }

            if (count != ans1[z]) {
                return;
            }
        }
        answer += 1;
    }
}