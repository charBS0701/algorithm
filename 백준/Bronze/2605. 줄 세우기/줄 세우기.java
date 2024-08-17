import java.io.*;
import java.util.*;
public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> row = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n=1; n<=N; n++) {
		    int idx = Integer.parseInt(st.nextToken());
		    row.add(row.size()-idx ,n);
		}
		
		for (Integer n : row) sb.append(n).append(" ");
		
        System.out.println(sb);
        
	}
}
