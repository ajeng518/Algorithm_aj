import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2688 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[65][10];
		// 첫번째 행 1로 초기화
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1L;
		}
		// 첫번째 열 1로 초기화
		for (int i = 1; i <= 64; i++) {
			dp[i][0] = 1L;
		}
		// dp배열 채우기
		for (int i = 2; i <= 64; i++) {
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			long result = 0;
			for (int i = 0; i < 10; i++) {
				result += dp[n][i];
			}
			System.out.println(result);
		}
	}
}
