import java.io.*;
import java.util.*;
public class Main
{
    static int N;
    static List<Serial> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    for (int n=0; n<N; n++) {
	        list.add(new Serial(br.readLine()));
	    }
	    Collections.sort(list);
	    for (int n=0; n<N; n++) {
	        sb.append(list.get(n).toString()).append("\n");
	    }
	    
	    System.out.println(sb);
	    
	}
	
	static class Serial implements Comparable<Serial> {
	    int len;
	    int sum;
	    String serial;
	    
	    public Serial(String serial) {
	        this.len = serial.length();
	        this.sum = getSum(serial);
	        this.serial = serial;
	    }
	    
	    int getSum(String serial) {
	        int sum = 0;
	        for (int i=0; i<len; i++) {
	            if (Character.isDigit(serial.charAt(i)))
	                sum += Integer.parseInt(String.valueOf(serial.charAt(i)));
	        }
	        return sum;
	    }
	    
	    @Override
	    public int compareTo(Serial other) {
	        if (this.len == other.len) {
	            if (this.sum == other.sum) {
	                return this.serial.compareTo(other.serial);
	            } else return this.sum - other.sum;
	        } else return this.len - other.len;
	    }
	    
	    @Override
	    public String toString() {
	        return this.serial;
	    }
	}
}