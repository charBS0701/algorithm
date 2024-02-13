import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count;
	static String[] noHear, noSee;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		noHear = new String[N];
		noSee = new String[M];

		for (int i = 0; i < N; i++) {
			noHear[i] = br.readLine();
		}
		for (int i = 0; i < M; i++) {
			noSee[i] = br.readLine();
		}

		Arrays.sort(noHear);
		Arrays.sort(noSee);

		int hearIdx = 0, seeIdx = 0;
			
		while (true) {
			if (hearIdx == N || seeIdx == M)
				break;
			
			if (noHear[hearIdx].equals(noSee[seeIdx])) { // 듣도보도 못했으면
				sb.append(noHear[hearIdx]).append("\n");
				count++;
				hearIdx++;
				seeIdx++;
			} else if (noHear[hearIdx].compareTo(noSee[seeIdx]) < 0) { // 듣잡이 사전순으로 작으면
				hearIdx++;
			} else if (noHear[hearIdx].compareTo(noSee[seeIdx]) > 0) { // 듣잡이 사전순으로 크면
				seeIdx++;
			}

		}
		System.out.println(count);
		System.out.println(sb);
	}

}
