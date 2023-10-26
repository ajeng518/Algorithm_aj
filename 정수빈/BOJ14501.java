import java.util.*;

public class BOJ14501 {
    static int N, max, days[][];
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        max = 0;
        days = new int[N][2];

        for(int i=0; i<N; i++) {
            days[i][0] = sc.nextInt();
            days[i][1] = sc.nextInt();
        }

        dfs(-1, 0, 0);

        System.out.println(max);
    }

    // 이전 인덱스, 가능한 최소 인덱스 및 합
    static void dfs(int pre, int index, int sum) {
        // 알맞게 끝나는 경우
        if(index == N) {
            if(max < sum)
                max = sum;
            return;
        }
        // 초과하는 경우
        if(index > N) {
            if(pre == -1)
                return;
            if(max < sum-days[pre][1])
                max = sum-days[pre][1];
            return;
        }

        for(int i=index; i<N; i++) {
            dfs(i, i+days[i][0], sum+days[i][1]);
        }
    }
}
