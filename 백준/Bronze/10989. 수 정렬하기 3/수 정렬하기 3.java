import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int P = Integer.parseInt(br.readLine());
        int[] hash = new int[10001];

        for (int i=0; i<P; i++) {
            hash[Integer.parseInt(br.readLine())]++;        }

        for (int i=1; i<10001; i++) {
            while(hash[i]-- > 0)
                bw.write(i + "\n");
          
        }
        bw.flush();
    }
}