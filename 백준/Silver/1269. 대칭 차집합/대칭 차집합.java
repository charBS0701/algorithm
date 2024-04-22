import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, count;
	static Set<Integer> setA = new HashSet<>();
	static Set<Integer> setB = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
			
		st = new StringTokenizer(br.readLine());
		for (int a = 0; a < A; a++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int b = 0; b < B; b++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int num : setA) {
			if (!setB.contains(num)) count++;
		}
		
		for(int num : setB) {
			if (!setA.contains(num)) count++;
		}
		
		System.out.println(count);
	}

}