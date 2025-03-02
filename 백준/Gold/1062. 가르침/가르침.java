import java.io.*;
import java.util.*;

public class Main {
    
    static int N, K;
    static List<Set<Character>> setList = new ArrayList<>();
    static Set<Character> totalSet = new HashSet<>();
    static List<Character> totalList = new ArrayList<>();
    static Set<Character> tmpSet = new HashSet<>();
    static char[] tgt;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());     
        
        if (K < 5) {
            System.out.println(0);
            return;
        }
        
        for (int n=0; n<N; n++) {
            setList.add(new HashSet<>());
            int idx = setList.size()-1;
            
            String word = br.readLine();
            for (char c : word.substring(4,word.length()-4).toCharArray()) {
                if (c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c' ) continue;
                setList.get(idx).add(c);
                if (setList.get(idx).size() > K-5) {      // 못 읽는 단어
                    setList.remove(idx);
                    break;
                }
                if (!totalSet.contains(c)) totalList.add(c);
                totalSet.add(c);
            }
        }
        
        tgt = new char[K-5];
        comb(0,0);
        
        System.out.println(answer);       
        
    }
    
    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == K-5 || tgtIdx == totalSet.size()) {
            // 가능한 단어 개수 세기
            getCount();
            return;
        }

        for (int i = srcIdx; i < totalList.size(); i++) {
            tgt[tgtIdx] = totalList.get(i);
            tmpSet.add(totalList.get(i));
            comb(i+1, tgtIdx+1);
            tmpSet.remove(totalList.get(i));
        }
    }
    
    static void getCount() {
        int count = 0;
        for (Set<Character> set : setList) {
            boolean flag = true;
            for (char c : set) {
                if (!tmpSet.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        answer = Math.max(answer, count);
    }
}