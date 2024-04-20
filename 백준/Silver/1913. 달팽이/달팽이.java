// 1913 달팽이
// https://www.acmicpc.net/problem/1913

import java.io.*;
import java.util.*;

public class Main {
    static int N, target;
    static int[][] mat;
    static int[] loc = new int[2];
    static int y, x;
    static int[] dy = { -1, 0, 1, 0 }; // 상 우 하 좌
    static int[] dx = { 0, 1, 0, -1 }; // 상 우 하 좌
    static int dir; // 이동방향
    static int count = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        mat = new int[N][N];

        y = x = N / 2;  // 시작 위치 

        int goCnt = -1; // 해당방향으로 이동한 카운트
        int goLen = 1; // 해당방향으로 갈 수 있는 카운트
        int goLenCnt = 0; // 한 방향으로 몇 번 쭉 갔는지 카운트
        while (count <= N * N) {
            mat[y][x] = count++;
            goCnt++;

            if (goCnt == goLen) { // 방향 바꾸기
                if (dir == 3)
                    dir = 0;
                else
                    dir++;
                goCnt = 0;
                goLenCnt++;
                if (goLenCnt==2) {
                    goLenCnt =0;
                    goLen++;
                }
            }

            y = y + dy[dir];
            x = x + dx[dir];

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(mat[i][j]).append(" ");
                if (mat[i][j] == target) {
                    loc[0] = i;
                    loc[1] = j;
                }
            }
            sb.append("\n");
        }

        sb.append(loc[0]+1).append(" ").append(loc[1]+1);

        System.out.println(sb);

    }
}