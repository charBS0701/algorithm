import java.util.*;
import java.io.*;
public class Main
{
    static StringBuilder sb = new StringBuilder();
    static char[][] mat = new char[5][15];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<5; i++) {
		    String row = br.readLine();
		    for (int j=0; j<row.length(); j++) {
		        mat[i][j] = row.charAt(j);
		    }
		}
		
		for (int j=0; j<15; j++) {
		    for (int i=0; i<5; i++) {
		        if (!Character.isLetterOrDigit(mat[i][j])) continue;
		        sb.append(mat[i][j]);
		    }
		}
		
		System.out.println(sb);
	}
}
