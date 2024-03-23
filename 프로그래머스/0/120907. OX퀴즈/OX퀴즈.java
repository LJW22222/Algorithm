class Solution {
    public String[] solution(String[] quiz) {
        int total = 0;
        int i = 0;
        String[] answer = new String[quiz.length];
        for(String A1 : quiz){
            String dataList[] = A1.split(" ");
            int a = Integer.parseInt(dataList[0]);
            int b = Integer.parseInt(dataList[2]);
            if(dataList[1].equals("-")){
                total = a-b;
            }else{
                total = a+b;
            }
            
            if(total == Integer.parseInt(dataList[4])){
                answer[i] = "O";
            }else{
                answer[i] = "X";
            }
            i++;
        }
        
        
        return answer;
    }
}