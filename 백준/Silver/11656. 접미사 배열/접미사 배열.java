import java.io.*;
import java.util.*;

public class Main {

	static String str;
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		
		for (int i = 0; i <= str.length()-1; i++) {
			list.add(str.substring(i,str.length()));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
		
	}
}