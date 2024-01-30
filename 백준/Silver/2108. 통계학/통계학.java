import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// N(1 ≤ N ≤ 500,000), 홀수
		Map<Integer, Integer> list = new HashMap<>();
		List<Integer> aList = new ArrayList<>();
		for (int n = 0; n < N; n++) {
			int el = Integer.parseInt(br.readLine());
			list.put(el, list.getOrDefault(el, 0)+1);
			aList.add(el);
		}
		StringBuilder sb = new StringBuilder();
		
		Set<Entry<Integer, Integer>> kv = list.entrySet();

		// 산술평균
		double sum = 0;
		int size = 0;
		for (Entry<Integer, Integer> entry : kv) {
			sum += entry.getKey()*entry.getValue();
			size += entry.getValue();
		}
		sum = Math.round(sum/size);
		sb.append((int)sum).append("\n");
		
		// 중앙값
		Collections.sort(aList);
		sb.append(aList.get(aList.size()/2)).append("\n");
		
		// 최빈값
		int freq = 0;
		List<Integer> freqList = new ArrayList<>();
		for (Entry<Integer, Integer> entry : kv) {
			if (entry.getValue() > freq) {
				freq = entry.getValue();
				freqList.clear();
				freqList.add(entry.getKey());
			} else if (entry.getValue() == freq) {
				freqList.add(entry.getKey());
			}
		}
		if (freqList.size() >= 2) {
			Collections.sort(freqList);
			sb.append(freqList.get(1));
		} else {
			sb.append(freqList.get(0));
		}
		sb.append("\n");
		
		
		// 범위
		sb.append(aList.get(aList.size()-1)-aList.get(0)).append("\n");
		
		
		System.out.println(sb);
	}

}
