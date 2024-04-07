class Solution {
    public int[] solution(int[][] score) {
                int[] scoreList = new int[score.length];
        int z = 0;
        while (z < score.length ) {
            int rangking = 1;
            double avgData = ((double)score[z][0] + score[z][1]) / 2;
            for (int i = 0; i < score.length; i++) {
                if( avgData < ((double)score[i][0] + score[i][1]) / 2){
                    rangking++;
                }
            }
            scoreList[z] = rangking;
            z++;
        }
        return scoreList;
    }
}