import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		
		for (int i = 0; i < 5; i++) {	// 빙고 입력
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int tmp;
		int count=0;	// 사회자가 부른 횟수
		int result=0;
		
		for (int n = 0; n < 25; n++) {		// 사회자가 부르는 숫자	
			int bingo=0;	// 빙고 개수
			count++;
			tmp = sc.nextInt();		
			
			// 수를 찾아서 체크
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if ( arr[r][c] == tmp ) arr[r][c] = 0;
				}
			}
			
			// 가로 빙고 체크
			for (int i=0; i<5; i++) {
				for (int j = 0; j < 5; j++) {
					if (arr[i][j]!=0) break;
					if (j==4) bingo++;
				}
			}
			
			// 세로 빙고 체크
			for (int i=0; i<5; i++) {
				for (int j = 0; j < 5; j++) {
					if (arr[j][i]!=0) break;
					if (j==4) bingo++;
				}
			}			
			
			// 대각선 빙고 체크 1
			for (int i = 0; i < 5; i++) {
				if (arr[i][i]!=0) break;
				if (i==4) bingo++;
			}
			
			// 대각선 빙고 체크 2
			for (int i = 0; i < 5; i++) {
				if (arr[i][4-i]!=0) break;
				if (i==4) bingo++;
			}
			
			
			if (bingo>=3) {
				if(result==0) result = count;
			}
		}
		System.out.println(result);
	}

}
