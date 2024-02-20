import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] topo; // 진입차수 관리
	static List<List<Integer>> graph = new ArrayList<>(); // 순서 - 연결
	static Queue<Integer> que = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		topo = new int[N + 1]; // 0 dummy
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) { // 선후관계 입력
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
			topo[B]++; // 진입 차수 증가
		}

		// bfs <= 진입차수가 0인 정점(학생)을 모두 queue 에 넣고 시작
		// 출력은 꺼내면서 만들면 된다.
		// queue 에서 꺼내서 이동할 수 있는 (학생 순서를 세우는 - 꺼낸 학생 뒤에 오는 학생) 정점으로 이동 
		// 그 정점의 진입차수를 1개 줄인다. 만약 줄이고 난 뒤 진입차수가 0이면 queue 에 넣는다.
		
		for (int i = 1; i <= N; i++) {
			if(topo[i] == 0) {
				que.offer(i);
			}
		}
		
		while (! que.isEmpty() ) {
			int no = que.poll();
			// 출력
			sb.append(no).append(" ");
			
			// 꺼낸 번호(학생)에서 갈 수 있는 번호 탐색
			List<Integer> list = graph.get(no);
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int temp = list.get(i);
				// 차수감소
				topo[temp]--;
				if (topo[temp] == 0) {
					que.offer(temp);
				}
			}
		}
		System.out.println(sb);
		
	}
}
