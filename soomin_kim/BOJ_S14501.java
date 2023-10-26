import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class BOJ_S14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1]; // 상담
        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) { // 퇴사일을 넘어가는 지 체크
                // (오늘 + 상담완료일)에 저장된 최대 수입 vs 오늘 이전 최대 수입 + 오늘 상담을 선택해서 버는 수입
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            //오늘 상담을 선택 안하기 => 이전 최대 금액이 더 크면 갱신
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.print(dp[n]);
    }
}
