
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int listSize = Integer.parseInt(st.nextToken());
        ArrayList<numberXY> numberList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            st = new StringTokenizer(in.readLine());
            numberList.add(new numberXY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        numberList.sort(new XYsorted());
        for (numberXY numberXY : numberList) {
            System.out.println(numberXY.X + " " + numberXY.Y);
        }
    }

    public static class XYsorted implements Comparator<numberXY> {


        @Override
        public int compare(numberXY o1, numberXY o2) {
            if (o1.X == o2.X) {
                return o1.Y - o2.Y;
            }else{
                return o1.X - o2.X;
            }

        }
    }


    public static class numberXY {
        int X;
        int Y;

        public numberXY(Integer x, Integer y) {
            X = x;
            Y = y;
        }
    }
}
