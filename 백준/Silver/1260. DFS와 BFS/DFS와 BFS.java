import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visitedList;

    static ArrayList<Integer>[] arrayList;

    static Queue<Integer> BFSList;
    static Stack<Integer> DFSList;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken())+1;
        int B = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[A];
        for (int z = 0; z < A; z++) {
            arrayList[z] = new ArrayList<>();
        }
        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arrayList[c].add(d);
            arrayList[d].add(c);
            Collections.sort(arrayList[c]);
            Collections.sort(arrayList[d]);
        }

        visitedList = new boolean[A];
        DFS(F);
        System.out.println();
        visitedList = new boolean[A];
        BFS(F);

    }

    public static void DFS(int i) {
        if (visitedList[i]) {
            return;
        }
        visitedList[i] = true;
        System.out.print(i + " ");
        for (int integers : arrayList[i]) {
            if(!visitedList[integers]) {

                DFS(integers);
            }
        }
    }

    public static void BFS(int i) {
        System.out.print(i + " ");
        visitedList[i] = true;
        BFSList = new LinkedList<>();
        BFSList.add(i);
        do {
            Integer poll = BFSList.poll();
            for (int z : arrayList[poll]) {
                if (!visitedList[z]) {
                    BFSList.add(z);
                    visitedList[z] = true;
                    System.out.print(z + " ");
                }
            }
        } while (!BFSList.isEmpty());
    }
}
