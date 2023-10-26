import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int N, M, K;
    static int[] money; // 인출해야 할 금액들
    static int min, max, mid; // 이분탐색을 위한 금액의 최소, 최대 범위.

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        max = 10000 * 100000;
        for(int i=0; i<N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, money[i]);
        }
        while(min <= max) { // 이분 탐색을 완전히 다 돌 때까지
            mid = (min+max)/2;

            int cnt = 1;
            int current = mid;

            // 통장에서 돈 빼내기
            for(int m : money) {

                if (current < m) {
                    current = mid;
                    cnt++;
                }

                current -= m;

                // 현재 인출 횟수가 M보다 크면 반복문 종료
                if (M < cnt) break;

            }

            if (cnt > M) {
                // 현재 금액으로 인출 횟수가 M을 넘으면 좀 더 큰 금액이 필요
                min = mid+1;
            }
            else {
                // 현재 금액으로 인출 횟수가 M과 같거나 작으면 좀 더 작은 금액이 필요
                max = mid-1;
                K = mid; // M과 같을 때 현재 금액이 K원이 될 수 있음
            }

        }

        System.out.println(K);
    }
}