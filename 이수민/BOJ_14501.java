import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {

    static int N;
    static int[] t, p;
    static int[] profit;

    public static void consulting(){
        for(int i=0; i<N; i++){
            if (i+t[i] <= N){ // 지금 상담을 하게 된다면, N일 전까지 끝을 낼 수 있는지
                // 이미 정해진 i+t[i] 시점의 이익 vs 지금까지의 이익+오늘 상담 이익
                profit[i+t[i]] = Math.max(profit[i+t[i]], profit[i]+p[i]);
            }

            // 내일의 최대이익 >= 오늘의 최대이익
            profit[i+1] = Math.max(profit[i], profit[i+1]);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        t = new int[N];
        p = new int[N];
        profit = new int[N+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        consulting();
        System.out.println(profit[N]);


    }
}
