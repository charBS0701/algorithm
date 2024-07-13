import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		sb.append(A+B-C).append("\n").append(Integer.parseInt(Integer.toString(A) + Integer.toString(B))-C);
		
		System.out.println(sb);
	}
}