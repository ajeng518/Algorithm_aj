import java.io.*;
import java.util.*;

public class boj14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken()); // 상담을 완료하는데 걸리는 기간
            p[i] = Integer.parseInt(st.nextToken()); // 상담을 했을 때 받을 수 있는 금액
        }

        int[] result = new int[n+1];

        for (int i=1; i<=n; i++) { // 1일 ~ n일 순회
            // 오늘 상담을 하는 경우, 안 하는 경우 중 최댓값 갱신
            result[i] = Math.max(result[i], result[i-1]);

            // 상담을 완료하는 날짜
            int d = i + t[i-1] - 1;

            if (d <= n) {
                // 오늘 날짜에 받을 수 있는 금액 + 상담을 완료하는 날짜 전날까지 받은 금액
                result[d] = Math.max(result[d], p[i-1] + result[i-1]);
            }
        }

        System.out.println(result[n]);
    }
}
