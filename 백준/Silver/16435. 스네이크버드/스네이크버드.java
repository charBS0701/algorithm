import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L;
	static int[] hei;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		hei = new int[N];
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hei[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(hei);
		
		for (int i = 0; i < N; i++) {
			if (hei[i] > L) break;
			else {
				L++;
			}
		}
		
		System.out.println(L);
		
	}

}
