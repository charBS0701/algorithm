import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] scores = new double[N];
		
		int max=0;
		for (int n=0; n<N; n++) {	// 점수입력
			int score = sc.nextInt();
			scores[n] = score;
			max = Math.max(max, score);
		}
		
		for (int n=0; n<N; n++) {	// 점수변경
			scores[n] = (double)scores[n]/max*100;
		}
		
		double sum=0;
		for (int n=0; n<N; n++) { 	// 평균도출
			sum+=scores[n];
		}
		System.out.println(sum/N);
	}
}