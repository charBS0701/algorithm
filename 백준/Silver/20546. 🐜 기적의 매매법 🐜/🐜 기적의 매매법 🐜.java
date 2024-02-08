import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int BNP, TIMING;
		int bStock=0, tStock=0;
		BNP = TIMING = Integer.parseInt(br.readLine());
		
		int stock[] = new int[14];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < stock.length; i++) {		// 주가입력
			stock[i] = Integer.parseInt(st.nextToken());
		}
		
		int upCnt = 0;
		int dwCnt = 0;
		int prev = stock[0];
		for (int i = 0; i < 14; i++) {
			// 준현
			int tmp = BNP/stock[i];
			bStock += tmp;			// 주식구매
			BNP -= tmp*stock[i];	// 지불
			
			// 성민
			if (stock[i] > prev) {
				upCnt++;
				dwCnt = 0;
			} else if (stock[i] < prev) {
				dwCnt++;
				upCnt = 0;
			}
			
			if (dwCnt==3) {
				int tmp2 = TIMING/stock[i];
				TIMING -= tmp2*stock[i];
				tStock += tmp2;
			} else if (upCnt==3) {
				tStock = 0;
				TIMING += tStock * stock[i];
			}
		}
		
			
		// 총 자산 계산
		BNP += bStock * stock[13];
		TIMING += tStock * stock[13];
		
		System.out.println(BNP == TIMING ? "SAMESAME" : (BNP>TIMING ? "BNP" : "TIMING"));
	}
}
