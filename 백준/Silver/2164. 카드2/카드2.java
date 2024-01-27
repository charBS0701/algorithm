import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		while ( !(list.size()==1) ) {
			list.remove(0);
			
			if (list.size()==1) break;
			list.add(list.remove(0));
		}
		
		System.out.println(list.get(0));
	}
}