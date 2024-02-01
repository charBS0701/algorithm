import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] data;
	static int result=Integer.MAX_VALUE;
	static boolean[] selected;
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		data = new int[N][2];
		selected = new boolean[N];
		for (int n = 0; n < N; n++) {				// 맛 입력
			st = new StringTokenizer(br.readLine()); 
			data[n][0] = Integer.parseInt(st.nextToken());
			data[n][1] = Integer.parseInt(st.nextToken());
		}
		
		// 부분집합
		subset(0,1,0);
		System.out.println(result);
	}
	
	public static void subset(int idx, int sin, int ssn) {
		if (idx == N) {
			return;
		}
		
		
		int newsin = sin * data[idx][0];	// 새로운 신맛
		int newssn = ssn + data[idx][1];	// 새로운 쓴맛
		result = Math.min(result, Math.abs(newsin-newssn));
		
		selected[idx] = true;
		subset(idx+1, newsin, newssn);
		selected[idx] = false;
		subset(idx+1, sin, ssn);
		
	}
	

}
