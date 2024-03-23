import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static Map<String, Integer> map = new HashMap<>();
	static List<Integer> ids;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());		// 테스트 수
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());	// 테스트 당 파일 수 
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine())	;
				String name = st.nextToken();
				int id = Integer.parseInt(st.nextToken());
				if (!map.containsKey(name)) {
					map.put(name, id);
				} else {
					if (id < map.get(name)) {
						map.put(name, id);
					}
				}
			}
			
			ids = new ArrayList<>(map.values());
			Collections.sort(ids);
			
			for (Integer id : ids) {
				sb.append(id).append(" ");
			}
			sb.append("\n");
			map.clear();
			ids.clear();
			
		}
		
		System.out.println(sb);
	}
}
