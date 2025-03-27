import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int[] arr;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        
        answer = arr[0];
        int sum = arr[0];
        
        for (int i=1; i<N; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
        
    }
}