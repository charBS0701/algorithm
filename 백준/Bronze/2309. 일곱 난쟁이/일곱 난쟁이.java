import java.io.*;
import java.util.*;
public class Main
{
    static int[] dwarfs = new int[9];
    static boolean find;
    static int[] tgt = new int[7];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int n=0; n<9; n++) {
		    int tall = Integer.parseInt(br.readLine());
		    dwarfs[n] = tall;
		}		
		Arrays.sort(dwarfs);
		
		comb(0,0);
		
		System.out.println(sb);
	
	}
	
	static void comb(int srcIdx, int tgtIdx) {
	    if (find) return;
	    if (tgtIdx == 7){
	        if (Arrays.stream(tgt).sum() == 100) {
	            for (int tall : tgt) {
	                sb.append(tall).append("\n");
	            }
	            find = true;
	        }
	        return;
	    }
	    
	    if (srcIdx == 9) return;
	    
	    tgt[tgtIdx] = dwarfs[srcIdx];
	    
	    comb(srcIdx+1, tgtIdx+1);
	    comb(srcIdx+1, tgtIdx);
	    
	}
}