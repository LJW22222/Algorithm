import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String result = null;
        HashMap<String, Integer> dataList = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (dataList.containsKey(participant[i])) {
                dataList.replace(participant[i], dataList.get(participant[i])+1);
            }else{
                dataList.put(participant[i], 1);
            }
        }
        
        for (int i = 0; i < completion.length; i++) {
            if (dataList.get(completion[i]) > 0) {
                dataList.replace(completion[i], dataList.get(completion[i]) - 1);
            }else {
                dataList.replace(completion[i], 0);
            }
        }
        for (String key : dataList.keySet()) {
            if (dataList.get(key) == 1) {
                result = key;
                break;
            }
        }
        return result;
    }
}