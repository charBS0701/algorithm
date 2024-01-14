import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); // 1 ~ 1,000,000
			int result = 0;
			int[] flags = new int[10];
			
			for (int i=1; ; i++) {
				int num = N*i;
				
				// 각 자리수 체크
				while (num>0) {
					flags[num%10]++;
					num/=10;
				}
				
				// flags 체크
				int totalFlag = 1;
				for (int j=0; j<10; j++) {
					if (flags[j]==0) {
						totalFlag=0;
						break;
					}
				}
				
				if (totalFlag == 1) {
					result = i*N;
					break;
				}
			}
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}