import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] nums;
    static int min = Integer.MAX_VALUE;
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];      // 2 이상 100,000 이하
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = N-1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = nums[left];
                answer[1] = nums[right];
            }
            
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }        
        
        System.out.println(answer[0] + " " + answer[1]);
    }
}