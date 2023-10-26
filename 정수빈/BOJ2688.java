import java.util.*;
class BOJ2688F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      // dp 배열 최대 64까지 미리 계산한다
        long[][] dp = new long[64][10];

        for(int i=0; i<10; i++)
            dp[0][i] = i+1;
        for(int i=0; i<64; i++)
            dp[i][0] = 1;

        for(int i=1; i<64; i++) {
            for(int j=1; j<10; j++) {
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }

        int T = sc.nextInt();

        for(int t=1; t<=T; t++) {
            int n = sc.nextInt()-2; // 배열 인덱스에 맞춰서 계산
            long sum = 0;

          // 한 자릿수일 경우 계산하지 않는다
            if(n==-1) {
                System.out.println(10);
                return;
            }
          // 그 이상부터는 계산해 둔 값을 더해 준다
            for(int i=0; i<10; i++)
                sum += dp[n][i];

            System.out.println(sum);
        }
    }
}
