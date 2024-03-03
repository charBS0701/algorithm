import java.util.Scanner;

/**
 * 
 * @author THKim
 *
 */
public class Main {

	static int answer;
	static int N;
	static int[] col;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		col = new int[N + 1]; // 0번 행을 제외하고 작업하기 위해 1을 더한다.각 행에 하나씩만 배치할 수 있기 때문에 1차원, col[i]번째방에 여왕을 배치할 열값을
								// 저장한다.

		setQueens(1); // 1행부터 시도
		System.out.println(answer);
		in.close();
	}

	// 유도파트 : 현재 행의 첫열부터 무조건 퀸을 놓고 그 위치가 가능한지 체크하고 가능하다면 다음 행으로 퀸을 놓으러 재귀호출한다.
	// 가능하지 않다면 다음 열로 시도 한다.
	// 기본파트 : 마지막행까지 다 놓았다면 경우의 수 증가후 리턴
	public static void setQueens(int rowNo) {

		if (rowNo > N) { // 시도하려는 rowNo행번호가 N보다 크면 말판끝까지 다 놓은 경우
			answer++;
			return;
		}
		for (int j = 1; j <= N; j++) { // 해당 행의 1열부터 n열까지 퀸 놓는 시도
			col[rowNo] = j;
			if (checking(rowNo)) { // rowNo행의 j열의 상황으로 가능한지 체크하여 가능하다면 다음행 시도
				setQueens(rowNo + 1); // rowNo+1번째 행 시도
			}
		}
	}

	// rowNo행에 퀸을 놓을수 있는지 1행부터 기존 rowNo-1행까지 rowNo행와 비교하며 체크
	public static boolean checking(int rowNo) {
		for (int k = 1; k < rowNo; k++) {
			// 같은 행에 배치할수 없으므로 행은 비교할 필요 없고 열값에 대해서만 비교하면 됨
			// col[rowNo]:현재 퀸의 위치 , col[k] :이전 퀸들의 위치(k: 1~(rowNo-1))
			if (col[rowNo] == col[k] || Math.abs(col[rowNo] - col[k]) == rowNo - k) {// col[rowNo] == col[k] 열이 같은지 체크
																						// (한행에 하나씩 구하기 때문에 행체크 불필요)
				return false; // Math.abs(col[rowNo]-col[k]) == rowNo-k 대각선 체크 (열값차이와 행값차이가 같다면 대각선)
			}
		}
		return true;
	}
}