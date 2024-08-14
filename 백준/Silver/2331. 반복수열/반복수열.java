import java.util.*;
import java.io.*;

public class Main
{
    static int A, P;
    static int answer;
    static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		A = Integer.parseInt(input[0]);
		P = Integer.parseInt(input[1]);
		
		int now = A;
		list.add(now);
		while(true) {
		    int next = getSum(now);
		    if (list.contains(next)) {
		        answer = list.indexOf(Integer.valueOf(next));
		        break;
		    }
		    list.add(next);
		    now = next;
		}
		
		System.out.println(answer);
		
	}
	
	static int getSum(int num) {
	    int sum = 0;
	    while (num != 0) {
	        sum += Math.pow(num%10, P);
	        num /= 10;
	    }
	    return sum;
	}
}
