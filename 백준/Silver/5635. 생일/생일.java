import java.time.*;
import java.io.*;

class Main {
    
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    // 학생 수
        
        String name = null;
        int d = 0;
        int m = 0;
        int y = 0;
        
        Man youngest = new Man("tmp", LocalDate.of(1990,1,1)); 
        Man oldest = new Man("tmp", LocalDate.of(2010,12,31));
        
        for (int i=0; i<n; i++) {
            String str[] = br.readLine().split(" ");
            name = str[0];
            d = Integer.parseInt(str[1]);
            m = Integer.parseInt(str[2]);
            y = Integer.parseInt(str[3]);
            
            LocalDate bday = LocalDate.of(y, m, d);
            
            if (bday.isAfter(youngest.bday)) {
                youngest = new Man(name, bday);
            } else if (bday.isBefore(oldest.bday)) {
                oldest = new Man(name, bday);
            }
            
        }
        
        System.out.println(youngest.name);
        System.out.println(oldest.name);
        
    }
    
    static class Man {
        String name;
        LocalDate bday;
        
        public Man(String name, LocalDate bday) {
            this.name = name;
            this.bday = bday;
        }
    }
}