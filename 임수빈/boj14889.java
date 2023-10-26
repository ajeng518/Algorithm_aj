import java.io.*;
import java.util.*;

public class boj14889 {
	
	static int[][] s;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		visited = new boolean[n];
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j=0; j<n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0, 0, n);
		System.out.println(answer);
	}

	static void find(int start, int cnt, int n) {
		if (cnt == n/2) { // 선택 완료
			// 각 팀별 합 구하기
			int team1 = 0;
			int team2 = 0;
			
			for (int i=0; i<n-1; i++) {
				for (int j=i+1; j<n; j++) {
					if (visited[i] && visited[j]) {
						team1 += s[i][j] + s[j][i];
						continue;
					}
					
					if (!visited[i] && !visited[j]) {
						team2 += s[i][j] + s[j][i];
					}
				}
			}
			
			// 차이 값 계산 후 정답 갱신
			answer = Math.min(Math.abs(team1-team2), answer);
			
			if (answer == 0) {
				System.out.println(0);
				System.exit(0);
			}
			
			return;
		}
		
		// 조합
		for (int i=start; i<n; i++) {
			visited[i] = true;
			find(i+1, cnt+1, n);
			visited[i] = false;
		}
	}
}
