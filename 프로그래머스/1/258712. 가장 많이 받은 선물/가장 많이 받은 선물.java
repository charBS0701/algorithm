import java.util.*;
class Solution {
    static Map<String,Integer> nameIdx = new HashMap<>();
    static int[][] mat;  // 선물 표
    static int[] score;  // 선물지수
    public int solution(String[] friends, String[] gifts) {
        int size = friends.length;
        mat = new int[size][size];
        score = new int[size];
        
        for (int i=0; i<size; i++) nameIdx.put(friends[i], i);  // 인덱스 저장
        for (int i=0; i<gifts.length; i++) {        // 정보저장
            int from = nameIdx.get(gifts[i].split(" ")[0]);
            int to = nameIdx.get(gifts[i].split(" ")[1]);
            mat[from][to]++;
            score[from]++;
            score[to]--;
            
        }
        
        int[] next = new int[size];
        // 다음달 선물 교환식
        for (int i=0; i<size; i++) {    
            for (int j=i+1; j<size; j++) {
                if (mat[i][j] > mat[j][i]) next[i]++;
                else if (mat[j][i] > mat[i][j]) next[j]++;
                else if (score[i] > score[j]) next[i]++;
                else if (score[j] > score[i]) next[j]++;
            }
        }
        
        System.out.println(Arrays.toString(score));
        
        Arrays.sort(next);
        
        return next[size-1];
    }
}