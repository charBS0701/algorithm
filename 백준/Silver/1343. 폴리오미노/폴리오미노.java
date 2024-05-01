import java.io.*;
import java.util.*;

public class Main {
	static char[] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		board = br.readLine().toCharArray();

		int count = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 'X') {
				count++;
			} else if (board[i] == '.') {
				if (count % 4 == 0) {
					for (int j = 0; j < count / 4; j++) {
						sb.append("AAAA");
					}
				} else if ((count - 2) % 4 == 0) {
					for (int j = 0; j < count / 4; j++) {
						sb.append("AAAA");
					}
					sb.append("BB");
				} else if (count == 2) {
					sb.append("BB");
				} else {
					System.out.println(-1);
					return;
				}
				sb.append(".");
				count = 0;
			}
		}

		if (count != 0) {
			if (count % 4 == 0) {
				for (int j = 0; j < count / 4; j++) {
					sb.append("AAAA");
				}
			} else if ((count - 2) % 4 == 0) {
				for (int j = 0; j < count / 4; j++) {
					sb.append("AAAA");
				}
				sb.append("BB");
			} else if (count == 2) {
				sb.append("BB");
			} else {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(sb);
	}

}