import java.io.*;
import java.util.*;

public class Main {
    static List<Deque<Integer>> ballots = new ArrayList<>();
    static int[] voteCount;
    static boolean[] eliminated;
    static String[] candidates;
    static int totalVotes;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // number of candidates <= 20
        candidates = new String[n];
        eliminated = new boolean[n];
        voteCount = new int[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = br.readLine();
        }

        String line;
        while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            Deque<Integer> ballot = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                ballot.add(Integer.parseInt(st.nextToken()) - 1);
            }
            ballots.add(ballot);
            voteCount[ballot.peek()]++;
            totalVotes++;
        }

        while (true) {
            int maxVotes = 0;
            int minVotes = totalVotes;
            for (int i = 0; i < n; i++) {
                if (!eliminated[i]) {
                    if (voteCount[i] > maxVotes) {
                        maxVotes = voteCount[i];
                    }
                    if (voteCount[i] < minVotes) {
                        minVotes = voteCount[i];
                    }
                }
            }

            if (maxVotes > totalVotes / 2) {
                for (int i = 0; i < n; i++) {
                    if (voteCount[i] == maxVotes) {
                        System.out.println(candidates[i]);
                        return;
                    }
                }
            }

            if (maxVotes == minVotes) {
                for (int i = 0; i < n; i++) {
                    if (!eliminated[i]) {
                        System.out.println(candidates[i]);
                    }
                }
                return;
            }

            for (int i = 0; i < n; i++) {
                if (voteCount[i] == minVotes) {
                    eliminated[i] = true;
                }
            }

            Arrays.fill(voteCount, 0);

            for (Deque<Integer> ballot : ballots) {
                while (!ballot.isEmpty() && eliminated[ballot.peek()]) {
                    ballot.poll();
                }
                if (!ballot.isEmpty()) {
                    voteCount[ballot.peek()]++;
                }
            }
        }
    }
}
