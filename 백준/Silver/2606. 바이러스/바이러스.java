import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;
        list = new ArrayList[a];
        visited = new boolean[a];

        for (int i = 0; i < a; i++) {
            list[i] = new ArrayList<>();
        }

        for (int z = 0; z < b; z++) {
            st = new StringTokenizer(in.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            list[d-1].add(l);
            list[l-1].add(d);
        }
        for (int i = 0; i < a; i++) {
            if(!visited[i]){
                DFS(i);
                break;
            }

        }
        for (int f = 0; f < visited.length; f++) {
            if (visited[f]) {
                count++;
            }
        }
        System.out.println(count-1);
    }

    static void DFS(int a) {
        if (visited[a]) {
            return;
        }
        visited[a] = true;
        for (int integers : list[a]) {
            DFS(integers-1);
        }
    }
}
