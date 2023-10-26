package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_5014 {
	static int F, S, G, U, D, floor[];
	static boolean[] chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> q = new ArrayDeque<>();

		F = Integer.parseInt(st.nextToken());// 전체 건물 크기
		S = Integer.parseInt(st.nextToken());// 시작
		G = Integer.parseInt(st.nextToken());// 도착해야하는 곳!!!!!!
		U = Integer.parseInt(st.nextToken());// 올라가는 칸 수
		D = Integer.parseInt(st.nextToken());// 내려가는 칸 수

		floor = new int[F + 1];
		chk = new boolean[F + 1];

		q.offer(S);
		chk[S] = true;
		int result=bfs(q);
		if(result==-1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(result);
		}
	}

	private static int bfs(Deque<Integer> q) {

		while (!q.isEmpty()) {
			int size = q.size();
			while (--size >= 0) {
				int now = q.poll();
				if (now == G) {
					return floor[G];
				}

				if (now - D > 0 && chk[now - D] == false) {
					chk[now - D] = true;
					floor[now - D] = floor[now] + 1;
					q.offer(now - D);
				}
				if (now + U <= F && chk[now + U] == false) {
					chk[now + U] = true;
					floor[now + U] = floor[now] + 1;
					q.offer(now + U);
				}
			}

		}
		return -1;

	}
}
