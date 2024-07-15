import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=3; i>0; i--) {
            char[] arr = br.readLine().toCharArray();
            if (Character.isDigit(arr[0])) {
                N = Integer.parseInt(String.valueOf(arr)) + i;
                break;
            }
        }
        
        if (N%3==0 && N%5==0) System.out.println("FizzBuzz");
        else if (N%3==0) System.out.println("Fizz");
        else if (N%5==0) System.out.println("Buzz");
        else System.out.println(N);
    }
}