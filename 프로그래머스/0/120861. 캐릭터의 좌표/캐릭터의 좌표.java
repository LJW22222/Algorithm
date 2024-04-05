class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] result = {0,0};
        for(int i = 0; i < keyinput.length; i++){      
            if(keyinput[i].equals("left")){
                result[0]--;
            }else if(keyinput[i].equals("right")){
                result[0]++;
            }else if(keyinput[i].equals("up")){
                result[1]++;
            }else if(keyinput[i].equals("down")){
                result[1]--;    
            }
            result = returnlist(result, board);
        }
        return result;
    }
    public int[] returnlist(int[] result, int[] board){
        int[] newList = result;
        if(result[0] < board[0] / 2 * -1 || result[0] > board[0] / 2){
            if(result[0] < 0){
                newList[0] = board[0] /2 * -1;
            }else if(result [0] > 0){
                newList[0] = board[0] /2;
            }    
        }else if(result[1] < board[1] / 2 * -1 || result[1] > board[1] / 2 ){
            if(result[1] < 0){
                newList[1] = board[1] /2 * -1;
            }else if(result [1] > 0){
                newList[1] = board[1] /2;
            }
        }
        return newList;
    }
}