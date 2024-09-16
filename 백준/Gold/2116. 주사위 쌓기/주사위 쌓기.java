import java.util.*;
import java.io.*;

class Main {
    static int N;   // <= 10_000
    static int answer;
    static int[] pair = new int[]{5,3,4,1,2,0};  // 0-5, 1-3, 2-4 가 반대편 숫자
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int n=0; n<N; n++) {
            String[] dice = br.readLine().split(" ");
            int[] diceValue = new int[6];
            for (int i=0; i<6; i++) {
                diceValue[i] = Integer.parseInt(dice[i]);
            }
            list.add(diceValue);
        }
        
        for (int i=0; i<6; i++) {
            simul(i, 0, 0);
        }
        
        System.out.println(answer);
    }
    
    static void simul(int idx, int n, int sum) {    // 아랫면, 주사위번호, 합
    
        // 옆면은 idx, pair[idx] 빼고 다 가능
        int under = list.get(n)[idx];
        int up = list.get(n)[pair[idx]];
        
        int max = 0;
        if (under == 6 || up == 6) {
            if (under == 5 || up == 5) {
                max = 4;
            } else max = 5;
        } else max = 6;
        
        sum += max;
        
        int nextUnder = -1;
        
        if (n != N-1) { // 더 올릴 주사위가 있다면
            for (int i=0; i<6; i++) {
                if (list.get(n+1)[i] == up) {
                    nextUnder = i;
                    break;
                }
            }
            
            simul(nextUnder, n+1, sum);
            
        } else {    // 마지막 주사위이면
            answer = Math.max(answer, sum);
            return;
        }
        
    }
    
}