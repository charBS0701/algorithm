import java.io.*;

public class Main {
    static int g, s;
    static String W, S;
    static int[] count = new int[52];
    static int[] subCount = new int[52];
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        g = Integer.parseInt(input[0]); // 1~3000
        s = Integer.parseInt(input[1]); // g~3_000_000
        W = br.readLine();
        S = br.readLine();

        // W의 각 문자 개수 세기
        for (int i = 0; i < g; i++) {
            char c = W.charAt(i);
            if (Character.isUpperCase(c)) count[c - 'A']++;
            else count[c - 'a' + 26]++;
        }

        // S의 처음 g개의 문자 개수 세기
        for (int i = 0; i < g; i++) {
            char c = S.charAt(i);
            if (Character.isUpperCase(c)) subCount[c - 'A']++;
            else subCount[c - 'a' + 26]++;
        }

        // 처음 g개 문자 비교
        if (isValid()) answer++;

        // 슬라이딩 윈도우 적용
        for (int i = g; i < s; i++) {
            char prev = S.charAt(i - g);
            char curr = S.charAt(i);

            // 이전 문자 제거
            if (Character.isUpperCase(prev)) subCount[prev - 'A']--;
            else subCount[prev - 'a' + 26]--;

            // 현재 문자 추가
            if (Character.isUpperCase(curr)) subCount[curr - 'A']++;
            else subCount[curr - 'a' + 26]++;

            // 유효성 검사
            if (isValid()) answer++;
        }

        System.out.println(answer);
    }

    static boolean isValid() {
        for (int i = 0; i < 52; i++) {
            if (count[i] != subCount[i]) return false;
        }
        return true;
    }
}
