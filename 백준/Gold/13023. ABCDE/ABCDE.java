import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {

    static boolean visitList[];
    static int result;
    static ArrayList<Integer>[] newList;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        result = 0;
        newList = new ArrayList[a];
        for (int i = 0; i < a; i++) {
            newList[i] = new ArrayList<>();
        }

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            newList[c].add(d);
            newList[d].add(c);
        }
        visitList = new boolean[a];
        for (int i = 0; i < a; i++) {
            if(!visitList[i]) {
                DFS(i,1);
                if (result == 1) {
                    break;
                }
            }
        }
        System.out.println(result);
    }

    static void DFS(int a, int count) {
        if (count == 5 || visitList[a]) {
            result = 1;
            return;
        }

        visitList[a] = true;
        for (int i : newList[a]) {
            if (!visitList[i]) {
                DFS(i, count + 1);
            }
        }
        visitList[a] = false;
    }
}
