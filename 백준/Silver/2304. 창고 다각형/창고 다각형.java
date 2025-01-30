import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static int highestH;
    static List<Dot> list = new ArrayList<>();
    static List<Dot> list2 = new ArrayList<>();
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Dot(l,h));
            highestH = Math.max(highestH, h);     // 가장 높은 기둥 찾기
        }
        
        Collections.sort(list, (o1,o2) -> o1.l-o2.l);
        
        int highL=0;
        int highH=0;
        for (int n=0; n<N; n++) {
            // 왼쪽으로 더 높은 점 나타날 때마다 기록 (newL, newH)
            // 그리고 그 전의 점의 h와 새로운 점의 l 도 기록 (newL, h)
            Dot dot = list.get(n);
            if (dot.h > highL) {
                if (highH!=0) list2.add(new Dot(dot.l,highH));
                list2.add(new Dot(dot.l,dot.h));

                highH=dot.h;
                highL=dot.h;
                if (dot.h == highestH) break;
            }
            
        }
        
        int leftSize = list2.size();

        highL=0;
        highH=0;        
        for (int n=N-1; n>=0; n--) {
            // 오른쪽으로 더 높은 점 나타날 때마다 기록 (newL+1, newH)
            // 그리고 그 전의 점의 h와 새로운 점의 l 도 기록 (newL+1, h)
            Dot dot = list.get(n);
            if (dot.h > highL) {
                if (highH!=0) list2.add(leftSize, new Dot(dot.l+1,highH));
                list2.add(leftSize, new Dot(dot.l+1,dot.h));                
                highH=dot.h;
                highL=dot.h;
                if (dot.h == highestH) break;
            }
            
        }        
        
        // 왼쪽에서부터 2개씩 점의 (가로차이*세로) 를 answer 에 더하기
        while (!list2.isEmpty()) {
            Dot d1 = list2.remove(0);
            Dot d2 = list2.remove(0);
            answer += d1.h * (Math.abs(d1.l-d2.l));
        }        
        
        System.out.println(answer);        
        
    }
    
    static class Dot {
        int l;
        int h;
        
        public Dot(int l, int h) {
            this.l = l;
            this.h = h;
        }
        
        public String toString() {
            return "l: " + l + " h: " + h;
        }
    }
}