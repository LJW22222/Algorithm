import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
                Stack<Integer> dataList = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (dataList.isEmpty()) {
                dataList.add(arr[i]);
            }
            if (dataList.peek() != arr[i]) {
                dataList.add(arr[i]);
            }
        }
        int[] answer = new int[dataList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dataList.elementAt(i);
        }

        return answer;
    }
}