import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;	// 정점의 수 (1<=N<=200)
	public static void main(String[] args) throws Exception {
		
		for (int t = 1; t <= 10; t++) {	// 10번의 테스트케이스
			N = Integer.parseInt(br.readLine());	// 노드 갯수 입력
			boolean flag = true;
			// 리프노드가 아닌데 숫자이면 false
			// 리프노드가 형제가 없으면 false
			
			for (int n = 0; n < N; n++) {	// 정점 입력
				st = new StringTokenizer(br.readLine());
				st.nextToken();		// 노드번호 입력
				char now = st.nextToken().charAt(0);	// 현재노드 데이터 입력
				int leftIdx=0;
				if (st.hasMoreTokens()) {				// 데이터가 더 있으면
					leftIdx = Integer.parseInt(st.nextToken());	// 왼쪽자식 인덱스 입력
					if (!st.hasMoreTokens()) {	// 자식이 한쪽밖에 없으면 false
						flag = false;
//						break;
					} else {
						st.nextToken();		// 오른쪽자식 인덱스 입력
					}
				}
				// 자식노드가 있는데 현재가 숫자면 false
				if (leftIdx!=0 && Character.isDigit(now)) {
					flag = false;
//					break;
				}
			}
			sb.append("#").append(t).append(" ");
			sb.append(flag ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
}
