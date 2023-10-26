import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {

	static int N;
	static int[][] map;
	static boolean[] visit;
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		combi(0, 0);
		System.out.println(min);
	}

	public static void combi(int depth, int start) {
		if (depth == N / 2) { // 조합 완성
			int s_sum = 0;
			int l_sum = 0;
			for (int i = 0; i < N; i++) { // 점수 계산하기
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if (visit[i] && visit[j]) { // 스타트 팀
						sum += map[i][j];
					} else if (!visit[i] && !visit[j]) { // 링크 팀
						sum += map[i][j];
					}
				}
				if (visit[i]) {
					s_sum += sum;
				} else {
					l_sum += sum;
				}
			}
			min=Math.min(min, Math.abs(s_sum-l_sum));
			return;
		}

		for (int i = start; i < N; i++) {
			visit[i] = true;
			combi(depth + 1, i + 1);
			visit[i] = false;
		}
	}
}
