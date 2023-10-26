package dodo.src.cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14501 {
    static int N, T[], P[], dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        T = new int[N];
        P = new int[N];
        dp = new int[N + 1];

        //입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) {
                //현재 날자에 소요되는 시간을 추가한 날에 돈을 dp배열에 추가한다(최대값으로 갱신함)
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            //해당 날자에 일할 수 없을 경우, 이전가지 일한 최대 돈을 갱신해준다.
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);

    }
}
