import java.io.*;

class Main {
    
    static int N;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        answer = (int) Math.floor(Math.sqrt((double)N));
        
        System.out.println(answer);
        
    }
}