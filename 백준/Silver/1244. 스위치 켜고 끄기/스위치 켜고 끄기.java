import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] swi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());    // 스위치 개수
        swi = new int[N];

        st = new StringTokenizer(br.readLine()); 
        for (int n = 0; n < N; n++) {    // 초기 스위치 상태 입력
            swi[n] = Integer.parseInt(st.nextToken());
        }

        int stuN = Integer.parseInt(br.readLine());
        for (int i = 0; i < stuN; i++) {    // 학생 성별, 배정 스위치 입력
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int where = Integer.parseInt(st.nextToken())-1;

            doSwitching(gender, where);
        }

        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++) {
            sb.append(swi[n] + " ");
            if ((n+1)%20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void doSwitching(int gender, int where) {
        if (gender == 1) {    // 남자일 때
            for (int i = where; i<swi.length; ) {
                toggle(i);
                i = i + where+1;
            }
        } else if (gender == 2) {    // 여자일 때
            int d = 1;
            toggle(where);
            while(true) {
                if (where-d >= 0 && where+d < swi.length) {
                    if (swi[where-d] == swi[where+d]) {
                        toggle(where-d);
                        toggle(where+d);
                        d++;
                    } else break;
                } else break;
            }
        }
    }

    public static void toggle(int targetIdx) {
        if (swi[targetIdx] == 1) swi[targetIdx] = 0;
        else swi[targetIdx] = 1;
    }

}