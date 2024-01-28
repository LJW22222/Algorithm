import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int B = 0;
        Hashtable<String, Integer> dataList = new Hashtable<>();
        String next = in.next();
        for (int i = 1; i < number; i++) {
            String next2 = in.next();
            if (next2.equals("ENTER")) {
                B += dataList.size();
                dataList.clear();
            }else{
                dataList.put(next2, i);
            }

        }
        System.out.println(dataList.size()+B);
    }
}