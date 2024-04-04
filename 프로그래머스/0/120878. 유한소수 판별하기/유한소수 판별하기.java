class Solution {
    public int solution(int a, int b) {
        int c = 2;
        int result = 1;
        do {
            if (a % c == 0 && b % c == 0) {
                a = a / c;
                b = b / c;
            } else {
                c++;
            }
        } while (c <= a && c <= b);
        c = 2;
        while (true) {
            if (b < c) {
                break;
            }
            if (b % c == 0) {
                if (c != 2 && c != 5) {
                    result = 2;
                    break;
                }
                b /= c;

            }else{
                c++;
            }
        }
        return result;
    }
}