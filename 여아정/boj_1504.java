package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1504 {
	static class Node implements Comparable<Node> {
		int end;
		int len;

		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Node(int end, int len) {
			super();
			this.end = end;
			this.len = len;
		}

		@Override
		public int compareTo(Node o) {
			return len - o.len;
		}
	}

	static List<List<Node>> list;
	static int N, E, v1, v2;
	static int[] dist;
	static boolean[] chk;
	static int MAX = 200000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];// 시작점에서의 거리
		chk = new boolean[N + 1];// 가는거 체크

		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		// 간선 입력받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, len));
			list.get(b).add(new Node(a, len));
		}

		// 필수로 가야하는 정점 정보
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		// 경우1) 시작->v1->v2->N
		int load1 = 0;
		load1 += dijkstra(1, v1);
		load1 += dijkstra(v1, v2);
		load1 += dijkstra(v2, N);

		// 경우2)시작->v2->v1->N
		int load2 = 0;
		load2 += dijkstra(1, v2);
		load2 += dijkstra(v2, v1);
		load2 += dijkstra(v1, N);

		int result = 0;

		if (load1 >= MAX && load2 >= MAX)// 도달 하지 못하는 경우
			result = -1;
		else
			result = Math.min(load1, load2);// 최소값

		System.out.println(result);
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, MAX);
		Arrays.fill(chk, false);

		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int cur = node.end;

			if (chk[cur])//지나갔나?
				continue;
			chk[cur] = true;

			for (Node next : list.get(cur)) {
				if (!chk[next.end] && dist[next.end] > dist[cur] + next.len) {//다음 갈 곳을 지나가지 않았으면서 현재에서 다음 거리 합해도 클경우 가기.....
					dist[next.end] = dist[cur] + next.len;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}

		return dist[end];
	}

}
