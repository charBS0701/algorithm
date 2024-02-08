import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N;	// 친구 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int count = 1;
		
		for (int i = 1; i < N; i++) {
			count++;
			if (arr[i] <= count-1) {
				System.out.println(i+1);
				return;
			}
		}
	}

}
