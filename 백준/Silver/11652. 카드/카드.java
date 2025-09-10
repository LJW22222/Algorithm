import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        HashMap<Long, Long> dataList = new HashMap<>();

        int i1 = Integer.parseInt(st.nextToken());

        for (int i = 0; i < i1; i++) {
            st = new StringTokenizer(bf.readLine());
            Long number = Long.parseLong(st.nextToken());
            if (dataList.containsKey(number)) {
                Long i2 = dataList.get(number);
                dataList.put(number, i2 + 1);
                continue;
            }
            dataList.put(number, 1L);
        }

        ArrayList<Map.Entry<Long, Long>> list = new ArrayList<>(dataList.entrySet());
        list.sort((a,b) -> {
            if (Objects.equals(a.getValue(), b.getValue())) {
                return Long.compare(a.getKey(), b.getKey());
            }
            return Long.compare(b.getValue(), a.getValue());
        });

        System.out.printf(String.valueOf(list.get(0).getKey()));
    }
}
