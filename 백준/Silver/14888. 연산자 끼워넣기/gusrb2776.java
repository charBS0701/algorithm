import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	
	static int N;
	static ArrayList<Integer> src = new ArrayList<>();
	static int[] arr;
	static long minAns = Long.MAX_VALUE;
	static long maxAns = Long.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			src.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(1, src.get(0));
		System.out.println(maxAns);
		System.out.println(minAns);
	}
	
	
	public static void perm(int srcIdx, int sum) {
		if(srcIdx == N) {
			minAns = Math.min(minAns, sum);
			maxAns = Math.max(maxAns, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(arr[i] != 0) {
				arr[i]--;
				perm(srcIdx+1, cal(srcIdx, sum, i));
				arr[i]++;
			}
		}
	}
	
	
	public static int cal(int srcIdx,int sum,  int calIdx) {
		int ans = 0 ;
		switch(calIdx) {
			case 0:
				ans = sum + src.get(srcIdx);
				break;
			case 1:
				ans = sum - src.get(srcIdx);
				break;
			case 2:
				ans = sum * src.get(srcIdx);
				break;
			case 3:
				ans = sum / src.get(srcIdx);
		}
		return ans;
	}
}
