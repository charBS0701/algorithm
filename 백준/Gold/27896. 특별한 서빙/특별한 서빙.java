import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[] arr;
    static int sum;     // 불만도 계
    static int answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            pq.offer(arr[n]);
            sum += arr[n];
            if (sum >= M) {
                answer++;
                sum -= pq.poll() * 2;
            }
        }
        
        System.out.println(answer);

    }
}