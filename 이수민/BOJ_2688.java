import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2688 {
    static int n;
    static long[][] dp;

    static long findNumber(int n, int c) {
        if (dp[n][c] != 0) return dp[n][c]; // 이미 값이 존재하면 바로 돌려줌
        if (c == 9) return 1; // 맨 앞자리 수가 9이면, 줄어들지 않는 수는 1개 밖에 없음

        // dp 점화식
        dp[n][c] = findNumber(n, c+1) + findNumber(n-1, c);
        return dp[n][c];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new long[65][10];

        // 줄어들지 않는 한 자리 수는 각각 1개씩
        for(int i=0; i<10; i++) {
            dp[0][i] = 1;
        }

        for(int t=0; t<T; t++) {
            n = Integer.parseInt(br.readLine());

            System.out.println(findNumber(n, 0)); // 줄어들지 않는 n자리 수
        }
    }
}
