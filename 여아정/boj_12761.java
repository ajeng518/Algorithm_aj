package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_12761 {
	static int A, B, N, M;
	static int[] d;
	static int[] cong;
	static int[] chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		d = new int[] { -1, 1, -A, A, -B, B };//이동 칸 수
		cong = new int[] { A, B };//점프 가능
		chk = new int[100001];//체크=>최0~100000까지 가능하도록 설정

		System.out.println(bfs());
	}

	private static int bfs() {
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(N);//시작값 넣기
		int cnt = 0;

		while (!q.isEmpty()) {

			int size = q.size();
			while (--size >= 0) {//q사이즈 만큼 돌기
				int idx = q.poll();
				if (idx == M)//도착지점 오면
					return cnt;//카운트 출력

				for (int i = 0; i < 6; i++) {//6방향 돌기
					int nextIdx = idx + d[i];
					if (nextIdx < 0 || nextIdx > 100000 || chk[nextIdx] == 1)//이미 갔거나 범위 지나면 continue;
						continue;
					q.offer(nextIdx);
					chk[nextIdx] = 1;//큐에 넣은값 체킹해주기
				}
				for (int i = 0; i < 2; i++) {//2방향 돌기
					int nextIdx = idx * cong[i];//점프!!

					if (nextIdx < 0 || nextIdx > 100000 || chk[nextIdx] == 1)//이미 갔거나 범위 지나면 continue;
						continue;
					q.offer(nextIdx);
					chk[nextIdx] = 1;
				}
			}
			cnt++;
		}
		return cnt;
	}

}
