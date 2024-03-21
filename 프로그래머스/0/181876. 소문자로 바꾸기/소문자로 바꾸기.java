class Solution {
    public String solution(String myString) {
        String answer = ""; 
        
        for(char a : myString.toCharArray()){
            answer += Character.toLowerCase(a);
        }
        
        return answer;
    }
}