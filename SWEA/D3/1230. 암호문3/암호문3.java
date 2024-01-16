import java.util.*;
import java.io.FileInputStream;

class Solution {
    public static void doCommand(ArrayList<Integer> data, char command, Scanner sc) {
        switch (command) {
            case 'I':
                int x = sc.nextInt(); // x번째 암호문 뒤에
                int y = sc.nextInt(); // y개 암호문 삽입
                for (int s = 0; s < y; s++) {
                    data.add(x + s, sc.nextInt());
                }
                break;
            case 'D':
                int xD = sc.nextInt(); // x번째 암호문 뒤에
                int yD = sc.nextInt(); // y개 암호문 삭제
                for (int s = 0; s < yD; s++) {
                    data.remove(xD);
                }
                break;
            case 'A':
                int yA = sc.nextInt(); // 맨 뒤 y개 암호문 삽입
                for (int s = 0; s < yA; s++) {
                    data.add(sc.nextInt());
                }
                break;
        }
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 암호문 개수
            ArrayList<Integer> data = new ArrayList<>(); // 암호문 뭉치
            for (int n = 0; n < N; n++) { // 원본 암호문 뭉치 입력
                data.add(sc.nextInt());
            }
            int M = sc.nextInt(); // 명령어의 개수
            for (int m = 0; m < M; m++) { // 명령어 입력
                char command = sc.next().charAt(0); // 명령어 종류 입력(I,D,A)
                doCommand(data, command, sc); // 명령어 실행
            }

            // 결과 출력
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(data.get(i) + " ");
            }
        }
    }
}