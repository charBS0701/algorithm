import java.io.*;
import java.util.*;

public class Main
{
    
    static int kx, ky, sx, sy, N;
    static int[] dy = new int[]{0,0,-1,1,1,1,-1,-1};
    static int[] dx = new int[]{1,-1,0,0,1,-1,1,-1};
    static StringBuilder sb = new StringBuilder();
    

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
	    st = new StringTokenizer(br.readLine());
	    String king = st.nextToken();
	    kx = king.charAt(0) - 'A' + 1;
	    ky = Character.getNumericValue(king.charAt(1));
	    
	    String stone = st.nextToken();
	    sx= stone.charAt(0) - 'A' + 1;
	    sy = Character.getNumericValue(stone.charAt(1));
	    
	    N = Integer.parseInt(st.nextToken());
	    for (int n=0; n<N; n++) {
	        String op = br.readLine();
	        int d = -1;
	        if (op.equals("R")) d = 0;
	        else if (op.equals("L")) d = 1;
	        else if (op.equals("B")) d = 2;
	        else if (op.equals("T")) d = 3;
	        else if (op.equals("RT")) d = 4;
	        else if (op.equals("LT")) d = 5;
	        else if (op.equals("RB")) d = 6;
	        else if (op.equals("LB")) d = 7;
	        
	        int nkx = kx + dx[d];
	        int nky = ky + dy[d];
	        
	        if (nky < 1 || nkx < 1 || nky > 8 || nkx > 8) continue;
	        else if (nkx != sx || nky != sy) {
	            kx = nkx;
	            ky = nky;
	            continue;
	        } else {        // 돌이 있는 곳으로
	            int nsx = sx + dx[d];
	            int nsy = sy + dy[d];
	            
	            if (nsx < 1 || nsy < 1 || nsx > 8 || nsy > 8) continue;
	            kx = nkx;
	            ky = nky;
	            sx = nsx;
	            sy = nsy;
	        }
	    }
	    
	    sb.append((char)(kx + 'A' - 1)).append(ky).append("\n").append((char)(sx + 'A' - 1)).append(sy);
	    System.out.println(sb);
	}
}