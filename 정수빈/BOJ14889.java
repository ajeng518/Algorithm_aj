import java.util.*;

public class BOJ14889 {
    static int N, min, map[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N은 짝수, N/2씩 나눔
        N = sc.nextInt();
        min = Integer.MAX_VALUE;
        map = new int[N][N];

        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                map[i][j] = sc.nextInt();

        // dfs 로 조합을 뽑고 계산한다
        dfs(0, 0, new int[N]);

        // 능력치 최솟값
        System.out.println(min);
    }

    static void dfs(int count, int index, int[] arr) {
        // 절반을 뽑았을 경우, 재귀를 멈춘다
        if(count == N/2) {
            int[] team = new int[2];
            
            // 같은 팀끼리 팀 가중치를 더해준다
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i==j) continue;

                    if(arr[i] == arr[j]) {
                        team[arr[i]] += map[i][j];
                    }
                }
            }
                
            // 능력치의 최솟값을 구한다
            int value = Math.abs(team[0]-team[1]);
            if(min > value) min = value;

            return;
        }

        // 조합을 뽑는다
        for(int i=index; i<N; i++) {
            if(arr[i] == 1) continue;

            arr[i] = 1;
            dfs(count+1, i+1, arr);
            arr[i] = 0;
        }
    }
}
