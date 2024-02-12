package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class 특정거리의도시찾기_eg {
	static int visited[];
	static ArrayList<Integer>[] A;
	static int N, M, K, X;
	static List<Integer> answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();
		A = new ArrayList[N + 1];
		answer = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
		}
		visited = new int[N + 1]; // 방문 배열 초기화하기
		for (int i = 0; i <= N; i++) {
			visited[i] = -1;
		}
		BFS(X);
		for (int i = 0; i <= N; i++) {
			if (visited[i] == K) {
				answer.add(i);
			}
		}
		if (answer.isEmpty()) {
			System.out.println("-1");
		} else {
			Collections.sort(answer);
			for (int temp : answer) {
				System.out.println(temp);
			}
		}
	}

	// BFS 구현하기
	private static void BFS(int Node) {
		Deque<Integer> que = new ArrayDeque<Integer>();
		que.add(Node);
		visited[Node]++;
		while (!que.isEmpty()) {
			int now_Node = que.poll();
			for (int i : A[now_Node]) {
				if (visited[i] == -1) {
					visited[i] = visited[now_Node] + 1;
					que.add(i);
				}
			}
		}

	}
}
