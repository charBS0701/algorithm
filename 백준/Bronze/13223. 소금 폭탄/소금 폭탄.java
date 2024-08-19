import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] now = br.readLine().split(":");
		String[] after = br.readLine().split(":");
        
        int nowH = Integer.parseInt(now[0]);
        int nowM = Integer.parseInt(now[1]);
        int nowS = Integer.parseInt(now[2]);
        
        int aftH = Integer.parseInt(after[0]);
        int aftM = Integer.parseInt(after[1]);
        int aftS = Integer.parseInt(after[2]);
        
        aftS -= nowS;
        aftM -= nowM;
        aftH -= nowH;
        
        if (aftS < 0) {
            aftS += 60;
            aftM--;
        }
        if (aftM < 0) {
            aftM += 60;
            aftH--;
        }
        if (aftH < 0) {
            aftH += 24;
        }
        
        if (aftS == 0 && aftM == 0 && aftH == 0) aftH += 24;
        
        System.out.println(String.format("%02d:%02d:%02d", aftH, aftM, aftS));

	}
}
