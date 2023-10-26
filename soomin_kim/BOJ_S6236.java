import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S6236 {
    static int start, end, n, m, low, min;
    static int[] day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        day = new int[n];

        // 최대 금액 구하기
        for (int i = 0; i < n; i++) {
            day[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, day[i]);
        }

        min = 1000000000;
        findMin(low, 1000000000);
        System.out.println(min);
    }
    
    public static void findMin(int start, int end){
        int mid = (start + end) / 2;

        if(mid < start) return;

        if(getCount(mid)<= m) {
            findMin(start, mid - 1);
            min = Math.min(min, mid);
        }
        else { //
            findMin(mid+1, end);
        }

    }

    private static int getCount(int k) {
        int count = 1; //일단 한번 뽑음
        int charge = k - day[0];

        for (int i = 1; i < n; i++) {

            if(charge - day[i] >= 0) // 잔돈 계산
                //잔돈이 남으면 저장
                charge -= day[i];
            //잔돈이 음수면 돈을 인출해야함! 잔돈 리필
            else if(charge - day[i] < 0) {
                charge = k - day[i];
                count++;
            }
        }
        return count;
    }
}
