class Solution {
    public String solution(String myString) {
        String answer = "";
        for(char j : myString.toCharArray()){
            answer += Character.toUpperCase(j);
        }
        return answer;
    }
}