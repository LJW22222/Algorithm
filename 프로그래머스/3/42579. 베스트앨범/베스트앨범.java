import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
               ArrayList<Integer> result = new ArrayList<>();
        int[] answer;
        //장르별 재생횟수 List
        HashMap<String,ArrayList<Integer>> playList = new HashMap<>();
        //장르별 재생 횟수 총합
        HashMap<String, Integer> playSumLists = new HashMap<>();
        //장르별 노래 중복 순위
        HashMap<Integer, ArrayList<Integer>> playListsRank = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (playListsRank.get(plays[i]) == null) {
                playListsRank.put(plays[i], new ArrayList<>());
                playListsRank.get(plays[i]).add(i);
            }else{
                playListsRank.get(plays[i]).add(i);
            }
            if (playList.get(genres[i]) == null) {
                playSumLists.put(genres[i], plays[i]);
                playList.put(genres[i],new ArrayList<>());
                playList.get(genres[i]).add(plays[i]);
            }else{
                playSumLists.put(genres[i], playSumLists.get(genres[i]) + plays[i]);
                playList.get(genres[i]).add(plays[i]);
            }
        }

        //장르 순서별 정리
        List<String> genresList = new ArrayList<>(playSumLists.keySet());
        Collections.sort(genresList, (v1, v2) -> (playSumLists.get(v2).compareTo(playSumLists.get(v1))));

        int testNumber= 0 ;
        while(genresList.size() > testNumber){
            ArrayList<Integer> integers = playList.get(genresList.get(testNumber));
            Collections.sort(integers, Collections.reverseOrder());
            if (integers.size() >= 2) {
                if(playListsRank.get(integers.get(0)).size() >= 2){
                    result.add(playListsRank.get(integers.get(0)).get(0));
                    result.add(playListsRank.get(integers.get(0)).get(1));
                }else{
                    result.add(playListsRank.get(integers.get(0)).get(0));
                    result.add(playListsRank.get(integers.get(1)).get(0));
                }
            }else{
                result.add(playListsRank.get(integers.get(0)).get(0));
            }
            testNumber++;
        }
        answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}