class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int a = (numer1 * denom2) + (numer2 * denom1);
        int b = denom1 * denom2;

        
        answer[0] = a/GCD(a,b);
        answer[1] = b/GCD(a,b);
        return answer;
    }
    public static int GCD(int a, int b){
        if ( a % b == 0){
            return b;
        }
        return GCD(b, a % b);
    }
}