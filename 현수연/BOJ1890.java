import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, arr[][];
    static long cnt[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N]; // 입력받을 게임판 배열
        cnt = new long[N][N]; // 게임판 배열에서 카운팅할 가는 경로 횟수 배열
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(in[j]);
        }
        cnt[0][0]=1; // 누적으로 카운팅 합을 더해줄 것이기 때문에 0,0좌표에 1 값을 넣어 둡니다
        dp(); // dp함수를 사용합니다
        System.out.println(cnt[N-1][N-1]); // 최종 목적지의 경로 누적 합을 출력합니다
    }
    static void dp() {
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			if(arr[i][j]==0) continue; // 해당 칸이 0일 경우 continue
    			int nextX = i+arr[i][j]; // 다음에 들어갈 아래와 오른쪽 좌표를 각각 구합니다
                int nextY = j+arr[i][j];
                if(nextX<N) // 오른쪽으로 가는 좌표가 게임판을 벗어나지 않았다면
                	cnt[nextX][j]+=cnt[i][j]; // 경로 횟수를 해당 칸에 더해줍니다
                if(nextY<N) // 아래로 가는 좌표가 게임판을 벗어나지 않았다면
                	cnt[i][nextY]+=cnt[i][j]; // 경로 횟수를 해당 칸에 더해줍니다
    		}
    	}
    }
}