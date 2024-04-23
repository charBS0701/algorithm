import java.io.*;
import java.util.*;

public class Main {
	static int S1, S2, S3;
	static int[] count;
	static int maxIdx, maxCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S1 = Integer.parseInt(st.nextToken());
		S2 = Integer.parseInt(st.nextToken());
		S3 = Integer.parseInt(st.nextToken());
		
		count = new int[S1+S2+S3+1];
		for (int s1 = 1; s1 <= S1; s1++) {
			for (int s2 = 1; s2 <= S2; s2++) {
				for (int s3 = 1; s3 <= S3; s3++) {
					int sum = s1+s2+s3; 
					count[sum]++;
					if (count[sum] > maxCnt) {
						maxCnt = count[sum];
						maxIdx = sum;
					}
				}
			}
		}
		
		System.out.println(maxIdx);
		
	}
}