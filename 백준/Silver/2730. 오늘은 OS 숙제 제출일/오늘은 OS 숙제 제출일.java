import java.io.*;
import java.util.*;

public class Main {

	static int T;
	static int year, month, day, subYear, subMonth, subDay;
	static int[] daysForMonths = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int flattenDay, flattenSubDay;
	static String str;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			// 초기화
			month = flattenDay = flattenSubDay = 0;
			// 입력
			st = new StringTokenizer(br.readLine());
			StringBuilder tmp = new StringBuilder();
			
			// 마감기한
			str = st.nextToken();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c != '/')
					tmp.append(str.charAt(i));
				else {
					if (month == 0) {
						month = Integer.valueOf(tmp.toString());
					} else {
						day = Integer.valueOf(tmp.toString());
					}
					tmp.setLength(0); // 비우기
				}

				if (i == str.length() - 1) {
					year = Integer.valueOf(tmp.toString());
					tmp.setLength(0); // 비우기
				}
			}
			
			// 제출날짜
			str = st.nextToken();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c != '/')
					tmp.append(str.charAt(i));
				else {
					subMonth = Integer.valueOf(tmp.toString());
					tmp.setLength(0); // 비우기
				}

				if (i == str.length() - 1)
					subDay = Integer.valueOf(tmp.toString());
			}
			
			subYear = year;
			// 연도가 바뀔 경우
			if (month == 12 && subMonth == 1) {
				subYear = year+1;
			} else if (month == 1 && subMonth == 12) {
				subYear = year-1;
			}

			// 날짜 1차원화
			if (isLeapYear(Math.min(year, subYear)))	 // 윤년 처리
				daysForMonths[2] = 29;
			else
				daysForMonths[2] = 28;
			
			for (int i = 1; i < month; i++) { // 마감기한
				flattenDay += daysForMonths[i];
			}
			flattenDay += day;

			for (int i = 1; i < subMonth; i++) { // 제출날짜
				flattenSubDay += daysForMonths[i];
			}
			flattenSubDay += subDay;
			
			// 연도가 바뀔 경우
			if (month == 12 && subMonth == 1) {
				for (int i = 1; i <= 12; i++) { 
					flattenSubDay += daysForMonths[i];
				}
			} else if (month == 1 && subMonth == 12) {
				for (int i = 1; i <= 12; i++) { // 마감기한
					flattenDay += daysForMonths[i];
				}
			}


			// 계산
			int diff = Math.abs(flattenDay - flattenSubDay);
			if (flattenDay == flattenSubDay) {
				sb.append("SAME DAY\n");
			} else if (Math.abs(flattenDay - flattenSubDay) > 7) {
				sb.append("OUT OF RANGE\n");
			} else {
				sb.append(subMonth).append("/").append(subDay).append("/").append(subYear).append(" IS ")
						.append(diff);
				if (diff > 1) sb.append(" DAYS ");
				else if (diff == 1) sb.append(" DAY ");
				if (flattenDay > flattenSubDay) sb.append("PRIOR\n");
				else if (flattenDay < flattenSubDay) sb.append("AFTER\n");
			}
		}

		System.out.println(sb);
	}

	static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		return false;
	}
}