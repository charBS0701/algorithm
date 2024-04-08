// 5430 AC
// https://www.acmicpc.net/problem/5430

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static int T;
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String func = br.readLine(); // 길이 : 1~100_000
			list.clear();
			int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수 0~100_000
			boolean errorFlag = false;
			boolean reversed = false;
			String s = br.readLine();

			boolean numberStart = false;
			int startIdx = -1;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c >= '0' && c <= '9' && !numberStart) { // 숫자 나오기 시작
					numberStart = true;
					startIdx = i;
				} else if (!(c >= '0' && c <= '9') && numberStart) { // 숫자 다 나옴
					list.add(s.substring(startIdx, i));
					numberStart = false;
				}
			}

			for (int i = 0; i < func.length(); i++) {
				char c = func.charAt(i);
				switch (c) {
				case 'R':
					if (!reversed) {
						reversed = true;
					} else {
						reversed = false;
					}
					break;
				case 'D':
					if (list.isEmpty())
						errorFlag = true;
					else {
						if (!reversed)
							list.remove(0);
						else
							list.remove(list.size() - 1);
					}
					break;
				}
				if (errorFlag)
					break;
			}

			if (errorFlag)
				sb.append("error");
			else {
				sb.append("[");
				if (!reversed) {
					for (String str : list) {
						sb.append(str).append(",");
					}
				} else {
					for (int i = list.size()-1; i >= 0; i--) {
						sb.append(list.get(i)).append(",");
					}
				}
				if (sb.charAt(sb.length() - 1) == ',')
					sb.deleteCharAt(sb.length() - 1);
				sb.append("]");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}