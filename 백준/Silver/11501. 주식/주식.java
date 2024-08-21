import java.io.*;
import java.util.*;
public class Main
{
    static int T;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
		    int N = Integer.parseInt(br.readLine());
		    long value = 0;
		    int stock = 0;
		    int[] sp = new int[N];
		    boolean[] goUp = new boolean[N];
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for (int n=0; n<N; n++) {
		        sp[n] = Integer.parseInt(st.nextToken());
		    }
		    
		    int max = sp[N-1];
		    for (int n=N-1; n>=0; n--) {
		        if (max > sp[n]) goUp[n] = true;
		        else {
		            goUp[n] = false;
		            max = sp[n];
		        }
		    }
		    
		    for (int n=0; n<N; n++) {
		        if (goUp[n]) {      // 후에 더 높은 가격이 있으면 산다
		            value -= sp[n];
		            stock++;
		        } else {    // 지금이 고가이면
                    if (stock != 0) {   // 주식이 있으면 다 판다
                        value += stock * sp[n];
                        stock = 0;
                    }
		        }
		    }
		    
		    
		    sb.append(value).append("\n");
		    
		}
		
		System.out.println(sb);
	}
}
