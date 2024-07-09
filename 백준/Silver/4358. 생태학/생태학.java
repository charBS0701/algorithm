import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map = new TreeMap<>();
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String tree = br.readLine();
            if (tree == "\n" || tree == null) break;
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            count++;
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        for (Map.Entry<String, Integer> entry : entrySet) {
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", (float)entry.getValue()/count*100)).append("\n");
        }

        System.out.println(sb.toString());

    }
}