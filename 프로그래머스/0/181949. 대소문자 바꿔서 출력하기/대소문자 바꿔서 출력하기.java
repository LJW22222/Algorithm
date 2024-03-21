import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String result = "";
        for(char da : a.toCharArray()){
            if(Character.isUpperCase(da)){
                result = result + Character.toLowerCase(da);
            }else if(Character.isLowerCase(da)){
                result = result + Character.toUpperCase(da);
            }
        }
        System.out.println(result);
    }
}