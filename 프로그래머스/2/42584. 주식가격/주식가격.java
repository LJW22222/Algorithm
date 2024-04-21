import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int z = i+1; z < prices.length; z++) {
                sum++;
                if (prices[i] > prices[z]) {
                    answer[i] = sum;
                    break;
                }else{
                    answer[i] = sum;
                }
            }
            sum = 0;
        }
        return answer;
    }
}