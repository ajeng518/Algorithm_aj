import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_S2531 {
    static int n, d, k, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //a 접시의 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가지의 수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] belt = new int[n + k];

        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] visited = new int[d+1];
        //쿠폰 값
        visited[c]++;
        int count = 1;

        for (int i = 0; i < k; i++) {
            belt[n + i] = belt[i];

            visited[belt[i]]++;
            if(visited[belt[i]] == 1) count++;
        }

        int max = count;

        for (int i = 1; i <= n; i++) {
            if (max == d) break;
            //앞에 하나 빼고
            visited[belt[i-1]]--;
            if(visited[belt[i-1]] == 0) count--;
            //끝에 하나 더한다.
            visited[belt[i+k-1]]++;
            if(visited[belt[i+k-1]] == 1) count++;

            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}