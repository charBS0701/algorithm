import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static boolean mat[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        mat = new boolean[H][W];
        st = new StringTokenizer(br.readLine());
        for (int w=0; w<W; w++) {
            int height = Integer.parseInt(st.nextToken());
            for(int h=0; h<height; h++) {
                mat[h][w] = true;
            }
        }

//        for (int h=0; h<H; h++) {
//            System.out.println(Arrays.toString(mat[h]));
//        }

        int result = 0;

        for (int h=0; h<H; h++) {
            int count = 0;
            boolean flag = false;
            for (int w=0; w<W; w++) {
                if (!flag && mat[h][w]) {
                    flag=true;
                } else if (flag && !mat[h][w]) {
                    count++;
                } else if (flag && mat[h][w]) {
                    result += count;
                    count = 0;
                }
            }
        }

        System.out.println(result);
    }
}
