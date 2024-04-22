import java.io.*;
import java.util.*;

public class Main {

	static String S;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		int len = S.length();
		String sub;
		for (int i = 0; i < len; i++) {
			for (int j = 0; i + j < len; j++) {
				sub = S.substring(i, len-j);
				if (set.contains(sub))
					continue;
				else
					set.add(sub);
			}
		}

		System.out.println(set.size());
	}
}