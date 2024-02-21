import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        list = new ArrayList[A];
        visited = new boolean[A];
        int count = 0;

        for (int i = 0; i < A; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < B; i++){
            st = new StringTokenizer(in.readLine());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            list[C-1].add(D);
            list[D-1].add(C);
        }

        for (int z = 0; z < A; z++) {
            if(!visited[z]){
                DFS(z);
                count++;
            }
        }
        System.out.println(count);
    }

    static void DFS(int z) {
        if (visited[z]) {
            return;
        }
        visited[z] = true;
        for (int i : list[z]) {
            DFS(i-1);
        }
    }
}