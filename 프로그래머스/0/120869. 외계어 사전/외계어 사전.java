import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for (int i = 0; i < dic.length; i++) {
            int number = 0;
            for (int z = 0; z < spell.length; z++) {
                if (dic[i].contains(spell[z])) {
                    number++;
                }
            }
            if (spell.length == number) {
                answer = 1;
            }
        }

        return answer;
    }
}