import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer> list = new ArrayList<>();
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (st.hasMoreElements()) {		 // 입력이 2개일 때
				int element = Integer.parseInt(st.nextToken());
				switch(command) {
				case "push_front":
					list.add(0,element);
					break;
				case "push_back":
					list.add(element);
					break;
				}
				continue;
			}
			switch(command) {
				case "pop_front":
					if (list.size() != 0) {
						System.out.println(list.remove(0));
					} else {
						System.out.println(-1);
					}
					break;
				case "pop_back":
					if (list.size() != 0) {
						System.out.println(list.remove(list.size()-1));
					} else {
						System.out.println(-1);
					}
					break;
				case "size":
					System.out.println(list.size());
					break;
				case "empty":
					if (list.size() == 0) System.out.println(1);
					else System.out.println(0);
					break;
				case "front":
					if (list.size() == 0) System.out.println(-1);
					else System.out.println(list.get(0));
					break;				
				case "back":
					if (list.size() == 0) System.out.println(-1);
					else System.out.println(list.get(list.size()-1));
					break;
			}
			
		}
	}
}