class Solution {
    public int solution(int[][] dots) {

        int a = 0;
        int b = 0;
        int i = 1;
        while(a == 0 || b == 0){
            if(dots[0][0] == dots[i][0]){
                a = dots[0][1] - dots[i][1];

            }
            if(dots[0][1] == dots[i][1]){
                b = dots[0][0] - dots[i][0];
            }
            i++;
        }
        a = a < 0 ? a * -1 : a;
        b = b < 0 ? b * -1 : b;
        return a*b;
    }
}