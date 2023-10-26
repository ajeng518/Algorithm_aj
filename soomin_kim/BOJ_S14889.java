import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_S14889 {

    static int n;
    static int min;
    static int[][] graph;
    static boolean[] visited;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n];
        min = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(min);
    }

    public static void dfs(int count, int index){
        if(count == n/2){
            //차이를 구하는 함수
            different();
            return;
        }

        //조합 => 팀 구하기~
        for(int i = index; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(count+1, i+1);
            visited[i] = false;
        }
    }

    public static void different(){
        int sumStart = 0; // Start팀 능력치 합
        int sumLink = 0; // Link팀 능력치 합

        // 이거 반복문 범위 생각하느라 머리가 터질 뻔했음
        // 일단 조합결과가 오름차순인건 보장됨
        // 0, 2가 나오면 2, 0 능력치도 고려해주니까 i는 0~n-2까지하고 j는 i 바로 다음 인덱스부터 살펴보면 된다?
        // 설명을 잘 하고 싶은데 어렵다.
        for(int i = 0; i<n-1; i++){
            for (int j = i+1; j < n; j++) {

                if(visited[i] && visited[j]) {
                    sumStart += graph[i][j];
                    sumStart += graph[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    sumLink += graph[i][j];
                    sumLink += graph[j][i];
                }
            }
        }

        int diff = Math.abs(sumLink - sumStart);
        min = Math.min(min, diff);
    }
}
