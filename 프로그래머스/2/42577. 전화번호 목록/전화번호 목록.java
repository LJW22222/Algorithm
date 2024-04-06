import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
                Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            if (i == 0) {
                if (phone_book[i+1].indexOf(phone_book[i],0) == 0) {
                    answer = false;
                }
            }else if (i == phone_book.length-1) {
                if (phone_book[i-1].indexOf(phone_book[i],0) == 0) {
                    answer = false;
                }
            }else{
                if (phone_book[i+1].indexOf(phone_book[i],0) == 0 || phone_book[i-1].indexOf(phone_book[i],0) == 0) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}