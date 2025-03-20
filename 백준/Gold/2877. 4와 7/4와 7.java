import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int K = Integer.parseInt(br.readLine());
        
        String binary = Integer.toBinaryString(K + 1).substring(1);
        
        for (char c : binary.toCharArray()) {
            if (c == '0') sb.append('4');
            else sb.append('7');
        }
        
        System.out.println(sb);
    }
}
