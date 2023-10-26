import java.io.*;

public class BOJ2688 {
	static int T, N;
	static long result;
	static long[][] dp; // 자릿수에 특정 숫자를 넣을 수 있는 경우의 수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			result=0;
			N = Integer.parseInt(br.readLine());
			dp = new long[N+1][10]; // [자릿수][0~9]
			
			for(int i=0; i<10; i++) {
				dp[1][i] = 1; // 한 자릿수 초기화
			}
			for(int i=2; i<=N; i++) {
				for(int j=0; j<10; j++) {
					for(int k=0; k<=j; k++) {
						// i-1자리 숫자의 뒤에 숫자 붙이면 i자리수가 만들어지므로 
						// 붙이는 숫자보다 작거나 같은 이전 자리 경우의 수 다 더해주기
						dp[i][j] += dp[i-1][k];
					}
				}
			}
			for(int i=0; i<10; i++) {
				result += dp[N][i]; // N자리 수 0~9까지 다 더하기
			}
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}
}
