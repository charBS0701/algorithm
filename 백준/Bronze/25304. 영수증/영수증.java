import java.io.*;
import java.util.*;
public class Main
{
    static int X;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		for (int n=1; n<=N; n++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    sum += a*b;
		}
		
		sb.append(sum == X ? "Yes" : "No");
		
        System.out.println(sb);
        
	}
}
