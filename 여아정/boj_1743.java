package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_1743 {
	static int N, M, K;
	static boolean map[][], chk[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE;
		map = new boolean[N][M];
		chk = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {//2차원 배열에 값 넣기
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = true;
		}

		for (int i = 0; i < N; i++) {//맵 내, 가지 않았으면서 음식물이 있는 공간에 bfs 함수 실행
			for (int j = 0; j < M; j++) {
				if (!chk[i][j] && map[i][j])
					max = Math.max(max, bfs(i, j));
			}
		}
		System.out.println(max);
	}

	private static int bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });//초기값 넣어주기
		chk[x][y] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			while (--size >= 0) {
				int[] now = q.poll();
				cnt++;

				for (int i = 0; i < 4; i++) {//4방향 진행
					int nextX = now[0] + dx[i];
					int nextY = now[1] + dy[i];
					
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)//범위 벗어나면 continue
						continue;
					if (chk[nextX][nextY] || !map[nextX][nextY])//이미 간적있거나 음식물이 없는 곳이면 continue
						continue;
					q.offer(new int[] { nextX, nextY });//그 외에는 q에 넣어주기
					chk[nextX][nextY] = true;//체크표시
				}
			}
		}
		return cnt;
	}

}
