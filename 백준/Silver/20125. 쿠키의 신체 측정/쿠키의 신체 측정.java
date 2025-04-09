import java.io.*;
import java.util.*;

public class Main
{
    static class Dot {
        int x, y;
        public Dot(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    
    static int N;
    static char[][] mat;
    static Dot heart, dick;
    static StringBuilder sb = new StringBuilder();
    

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		mat = new char[N][N];
		
		for (int n=0; n<N; n++) {
		    mat[n] = br.readLine().toCharArray();
		}
		
		for (int n=0; n<N; n++) {
		    for (int m=0; m<N; m++) {
		        if (mat[n][m] == '*') {
		            heart = new Dot(n+1,m);
		            sb.append(heart.x+1).append(" ").append(heart.y+1).append("\n");
		            break;
		        }
		    }
		    if (heart != null) break;
		}
		
		int count = 0;
		for (int y=heart.y-1; y>=0 && mat[heart.x][y] == '*'; y--) count++;
		write(count);
		
		count = 0;
		for (int y=heart.y+1; y<N && mat[heart.x][y] == '*'; y++) count++;
		write(count);
		
		count = 0;
		for (int x=heart.x+1; x<N && mat[x][heart.y] == '*'; x++) count++;
		write(count);
		dick = new Dot(heart.x+count, heart.y);
		
		count = 0;
		for (int x=dick.x+1; x<N && mat[x][dick.y-1] == '*'; x++) count++;
		write(count);
		
		count = 0;
		for (int x=dick.x+1; x<N && mat[x][dick.y+1] == '*'; x++) count++;
		write(count);

        System.out.println(sb);
	}
	
	static void write(int count) {
	    sb.append(count).append(" ");
	}
}