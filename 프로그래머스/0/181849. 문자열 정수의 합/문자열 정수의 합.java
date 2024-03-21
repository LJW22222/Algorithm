class Solution {
    public int solution(String num_str) {

        int answer = 0;
        for(String i : num_str.split("")){
            int c = Integer.parseInt(i);
            answer += c;
        }
        return answer;
    }
}