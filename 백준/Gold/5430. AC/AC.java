// 5430 AC
// https://www.acmicpc.net/problem/5430

import java.io.*;
import java.util.*;

public class Main {

	static int T;
	static Deque<String> list = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String func = br.readLine(); // 길이 : 1~100_000
			list.clear();
			int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수 0~100_000
			boolean errorFlag = false; // 에러 발생 여부
			boolean reversed = false; // 순서 뒤집기 여부
			String s = br.readLine();

			boolean numberStart = false;
			int startIdx = -1;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c >= '0' && c <= '9' && !numberStart) { // 숫자 나오기 시작
					numberStart = true;
					startIdx = i;
				} else if (!(c >= '0' && c <= '9') && numberStart) { // 숫자 다 나옴
					list.offer(s.substring(startIdx, i));
					numberStart = false;
				}
			}

			for (int i = 0; i < func.length(); i++) { // 명령어 처리
				char c = func.charAt(i);
				switch (c) {
				case 'R': // 뒤집기 표시만
					if (!reversed) {
						reversed = true;
					} else {
						reversed = false;
					}
					break;
				case 'D': // 뒤집기일때와 아닐때 지우는 위치 다름
					if (list.isEmpty())
						errorFlag = true;
					else {
						if (!reversed)
							list.pollFirst(); // ArrayDeque 가 성능 더 좋을 듯
						else
							list.pollLast();
					}
					break;
				}
				if (errorFlag)
					break;
			}

			// 출력 처리
			if (errorFlag) // 에러일 때
				sb.append("error");
			else {
				sb.append("[");
				if (!reversed) { // 안 뒤집힘
					for (String str : list) {
						sb.append(str).append(",");
					}
				} else { // 뒤집한 상태
					while (!list.isEmpty())
						sb.append(list.pollLast()).append(",");
				}
				if (sb.charAt(sb.length() - 1) == ',') // 마지막 문자 처리
					sb.deleteCharAt(sb.length() - 1);
				sb.append("]");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}