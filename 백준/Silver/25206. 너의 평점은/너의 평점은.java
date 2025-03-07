import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        double sum = 0.0;
        double hakjum = 0.0;
        
        for (int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine());
            String sub = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            
            double weight = 0.0;
            
            if (grade.equals("A+")) {
                weight = 4.5;
            } else if (grade.equals("A0")) {
                weight = 4.0;
            } else if (grade.equals("B+")) {
                weight = 3.5;
            } else if (grade.equals("B0")) {
                weight = 3.0;
            } else if (grade.equals("C+")) {
                weight = 2.5;
            } else if (grade.equals("C0")) {
                weight = 2.0;
            } else if (grade.equals("D+")) {
                weight = 1.5;
            } else if (grade.equals("D0")) {
                weight = 1.0;
            } else if (grade.equals("F")) {
                weight = 0.0;
            } else if (grade.equals("P")) {
                continue;
            }
            
            sum += score * weight;
            hakjum += score;
        }
        
        System.out.println(sum/hakjum);
    }
}