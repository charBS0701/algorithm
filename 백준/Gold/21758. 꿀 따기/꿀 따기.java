import java.io.*;
import java.util.*;

public class Main
{
    
    static int N, answer;
    static int[] arr, sum1, sum2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		sum1 = new int[N+1];
		sum2 = new int[N+2];
		
		st = new StringTokenizer(br.readLine());
		for (int n=1; n<=N; n++) {
		    arr[n] = Integer.parseInt(st.nextToken());
		}
		for (int n=1; n<=N; n++) {
		    sum1[n] = sum1[n-1] + arr[n];
		}
		for (int n=N; n>=1; n--) {
		    sum2[n] = sum2[n+1] +arr[n];
		}
		
		// 꿀통이 오른쪽 끝인 경우
		int tmpSum = sum1[N] - sum1[1];
		int tmp = 0, tmpIdx = 0;
		
		for (int n=2; n<=N; n++) {
		    int honey = sum1[N] - sum1[n] - arr[n];
		    if (tmp < honey) {
		        tmpIdx = n;
		        tmp = honey;
		    }
		}
		
		tmpSum += tmp;
		
		answer = Math.max(answer, tmpSum);
		
		// 꿀통이 왼쪽 끝인 경우
		tmpSum = sum2[1] - sum2[N];
		tmp = 0; tmpIdx = 0;
		
		for (int n=N-1; n>=1; n--) {
		    int honey = sum2[1] - sum2[n] - arr[n];
		    if (tmp < honey) {
		        tmpIdx = n;
		        tmp = honey;
		    }
		}
		
		tmpSum += tmp;
		
		answer = Math.max(answer, tmpSum);
		
		// 꿀통이 벌 사이에 있는 경우
		for (int n=2; n<N; n++) {
		    tmpSum = sum1[n] - sum1[1];
		    tmpSum += sum2[n] - sum2[N];
		    
		    answer = Math.max(answer, tmpSum);
		}
		

		System.out.println(answer);
		
	}
}