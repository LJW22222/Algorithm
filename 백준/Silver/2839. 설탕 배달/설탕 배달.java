import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int Input_data = Integer.parseInt(in.nextLine());

        // 최종 데이터
        int result;

        result = Input_data / 5;
        Input_data = Input_data % 5;

        if(Input_data % 3 == 0){
            result += Input_data / 3;
        }else{
            while (true){
                result--;
                Input_data += 5;
                if(result < 0)
                    break;

                if(Input_data % 3 == 0){
                    result += Input_data/3;
                    break;
                }
            }

        }
        System.out.println(result);
    }
}
