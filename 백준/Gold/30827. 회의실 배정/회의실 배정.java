import java.io.*;
import java.util.*;

public class Main {
    
    static class Meeting implements Comparable<Meeting>{
        int from, to;
        public Meeting(int from, int to) {
            this.from = from;
            this.to = to;
        }
        
        @Override
        public int compareTo(Meeting o) {
            if (this.to == o.to) {
                return Integer.compare(this.from, o.from);
            } else return Integer.compare(this.to, o.to);
        }
    }
    
    static int K, N;
    static int answer;
    static Meeting[] meetings;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        meetings = new Meeting[N];
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            meetings[n] = new Meeting(from,to);
        }
        
        Arrays.sort(meetings);
        ArrayList<Integer> rooms = new ArrayList<>();
        
        for (Meeting m : meetings) {
            boolean flag = false;
            
            Collections.sort(rooms, (o1,o2) -> -Integer.compare(o1,o2));
            
            for (int n=0; n<rooms.size(); n++) {
                if (rooms.get(n) < m.from) {
                    rooms.set(n,m.to);
                    answer++;
                    flag = true;
                    break;
                }
            }
            
            if (flag == false && rooms.size() < K) {
                rooms.add(m.to);
                answer++;
            }
        }
        
        System.out.println(answer);
        
    }
}