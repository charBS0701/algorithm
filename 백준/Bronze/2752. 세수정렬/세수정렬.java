import java.io.*;
import java.util.*;
public class Main
{
    static int[] arr = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<3; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
		
	}
}