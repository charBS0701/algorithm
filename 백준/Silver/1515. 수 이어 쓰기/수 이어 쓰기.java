import java.io.*;
import java.util.*;

public class Main {

	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();

		int num = 1;
		String numStr = null;
		int tmpIdx = 0;
		boolean match = false;
		
		for (int i = 0; i < str.length();) {
			char n = str.charAt(i);

			if (tmpIdx == 0) {
				numStr = Integer.toString(num);
			}

			for (int j = 0; j < numStr.length(); j++) {
				if (j == 0) j = tmpIdx;

				if (n == numStr.charAt(j)) {
					if (i==str.length()-1) System.out.println(num);
					match = true;
					i++;
					if (j != numStr.length() - 1)
						tmpIdx = j + 1;
					else {
						num++;
						tmpIdx = 0;
					}
					break;
				} else match = false;
			}
			
			if (!match) {
				num++;
				tmpIdx = 0;
			}

		}

	}
}