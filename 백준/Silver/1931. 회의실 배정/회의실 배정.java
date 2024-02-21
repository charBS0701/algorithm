import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Meeting[] meetings;
	static int result;
	static int endTime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}

		Arrays.sort(meetings, (o1, o2) -> o1.end == o2.end ? o1.start - o2.start : o1.end - o2.end); // 정렬

		endTime = meetings[0].end; // 첫 회의 배정
		result++;

		for (int i = 1; i < meetings.length; i++) {
			if (endTime > meetings[i].start) { // 이전 회의가 끝나기전에 다음회의 시작시간이면
				continue; // 통과
			}
			endTime = meetings[i].end;
			result++;
		}

		System.out.println(result);

	}

	static class Meeting {
		int start;
		int end;

		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
