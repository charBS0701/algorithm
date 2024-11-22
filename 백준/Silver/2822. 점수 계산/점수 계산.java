import java.io.*;
import java.util.*;

public class Main
{
    
    static Long answer = 0L;
    static Score[] scores = new Score[8];
    static int[] indexes = new int[5];
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws Exception {
	    
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	   for (int i=0; i<8; i++) {
	       Long score = Long.parseLong(br.readLine());
	       scores[i] = new Score(i, score);
	   }
	   
	   Arrays.sort(scores);
	   
	   for (int i=8-5; i<8; i++) {
	       answer += scores[i].score;
	       indexes[i-3] = scores[i].idx+1;
	   }
	   
	   Arrays.sort(indexes);
	   
	   System.out.println(answer);
	   
   	   for (int i=0; i<=4; i++) {
   	       sb.append(indexes[i]).append(" ");
	   }
	   
	   System.out.println(sb);
	   
	}
	
	static class Score implements Comparable<Score> {
	    int idx;
	    Long score;
	    
	    public Score(int idx, long score) {
	        this.idx = idx;
	        this.score=  score;
	    }
	    
	    @Override
	    public int compareTo(Score other) {
	        return (int)(this.score - other.score);
	    }
	}
}
