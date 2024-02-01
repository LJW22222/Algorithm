import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader In = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(In.readLine());
        HashMap<String, Integer> dataList = new HashMap<>();
        int o = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        for (int i = 0; i < o; i++) {
            String input = In.readLine();
            if(input.length() >= Z) {
                if(dataList.containsKey(input)){
                    int integer = dataList.get(input);
                    dataList.put(input, integer+1);
                }else{
                    dataList.put(input, 1);
                }
            }
        }
        List<String> keySetList = new ArrayList<>(dataList.keySet());
        Collections.sort(keySetList);
        Collections.sort(keySetList, (s1, s2) -> s2.length() - s1.length());
        Collections.sort(keySetList, (o1, o2) -> dataList.get(o2).compareTo(dataList.get(o1)));
        for (String s : keySetList) {
            Out.write(s+"\n");
        }
        Out.flush();
    }
}