import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int count = 0;
			double dist = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
			
			if (x1==x2 && y1==y2) {	// 같은 위치에 터렛
				if (r1==r2) System.out.println(-1);	// 류재명에게로의 거리가 같을 떼
				else System.out.println(0);	// 측정한 거리가 다를 때
			} else if ( (r1+r2) == dist ) {	// 외접
				System.out.println(1);
			} else if ( dist == Math.abs(r1-r2) ) { // 내접
				System.out.println(1);
			} else if ( (r1+r2) < ( dist ) ) {  // 안 만날 때
				System.out.println(0);
			} else if ( dist < Math.abs(r1-r2) ) {	// 한 원안에 다른 원이 있는데 안 만날 때
				System.out.println(0);
			} else System.out.println(2);
			
		}
	}
}