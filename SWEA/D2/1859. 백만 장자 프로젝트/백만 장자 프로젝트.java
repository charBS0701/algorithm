import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수

        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt(); // 물건의 매매가를 알고 있는 일 수
            int[] price = new int[N]; // 각 날의 매매가

            for(int i=0; i<N; i++) {
                price[i] = sc.nextInt();
            }

            long maxPrice = price[N-1]; // 현재까지의 최대 매매가
            long profit = 0; // 이익

            for(int i=N-2; i>=0; i--) { // 뒤에서부터 앞으로 이동
                if(price[i] > maxPrice) { // 현재 매매가가 최대 매매가보다 크다면
                    maxPrice = price[i]; // 최대 매매가 갱신
                } else { // 현재 매매가가 최대 매매가보다 작다면
                    profit += maxPrice - price[i]; // 이익 계산
                }
            }

            System.out.println("#" + tc + " " + profit);
        }

        sc.close();
    }
}
