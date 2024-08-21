import java.io.*;
import java.util.*;
public class Main
{
    static int N;
    static int answer;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int me = Integer.parseInt(st.nextToken());
		int you = Integer.parseInt(st.nextToken());
		
		while (true) {
		    N = N/2 + N%2;
		    me = me/2 + me%2;
		    you = you/2 + you%2;
		    answer++;
		    if (me == you) {
		        System.out.println(answer);
		        break;
		        
		    }
		}
		
		
	}
}