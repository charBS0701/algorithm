import java.io.*;

class Main {
    
    static int N;
    static int[] scores;
    static int answer;    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[N];
        
        for (int n=0; n<N; n++) {
            int score = Integer.parseInt(br.readLine());
            scores[n] = score;
        }
        
        for (int n=N-2; n>=0; n--) {
            if (scores[n] >= scores[n+1]) {
                int diff = scores[n] - scores[n+1] + 1;
                answer += diff;
                scores[n] -= diff;
            }
        }
        
        System.out.println(answer);
        
    }
}