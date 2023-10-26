import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
    static int N;
    static int[][] ability;
    static boolean[] visited;
    static int min; // 두 팀 능력치 차이의 최소

    // 두 팀의 능력치와 그의 차이를 구함
    public static void compareAbility(){
        int start = 0;
        int link = 0;

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                // i와 j가 start 팀인 경우,
                if (visited[i] && visited[j]){
                    start += ability[i][j] + ability[j][i];
                }
                // i와 j가 link 팀인 경우,
                else if (!visited[i] && !visited[j]){
                    link += ability[i][j] + ability[j][i];
                }
            }
        }

        // 두 팀의 능력치 차이의 최솟값을 구하기
        min = Math.min(min, Math.abs(start-link));
    }

    // 팀 조합 만들기
    public static void makeTeam(int cnt, int idx){
        if (cnt == N/2){
            compareAbility();
            return;
        }
        
        for(int i=idx; i<N; i++){
            visited[i] = true;
            makeTeam(cnt+1, i+1);
            visited[i] = false;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        ability = new int[N][N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeTeam(0, 0);
        System.out.println(min);

    }
}
