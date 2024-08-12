import java.util.*;
import java.io.*;
public class Main
{
    static List<Integer> stack = new ArrayList<>();
    static int top = -1;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n=0; n<N; n++) {
		    String op = br.readLine();
		    if (op.length() > 1) {
		        int num = Integer.parseInt(op.split(" ")[1]);
		        ++top;
		        stack.add(num);
		    } else {
		        char o = op.charAt(0);
		        switch (o) {
		            case '2':
		                if (top > -1) sb.append(stack.remove(top--));
		                else sb.append(-1);
		                sb.append("\n");
		                break;
	                case '3':
	                    sb.append(top+1).append("\n");
	                    break;
                    case '4':
                        if (top == -1) sb.append(1);
                        else sb.append(0);
                        sb.append("\n");
                        break;
                    case '5':
                        if (top > -1) sb.append(stack.get(top));
                        else sb.append(-1);
                        sb.append("\n");
                        break;
		        }
		    }
		}
		System.out.println(sb);
	}
}
