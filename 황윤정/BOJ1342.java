import java.io.*;

public class BOJ1342 {
    static int[] alpha = new int[26]; // 알파벳 문자 별 갯수 저장 배열
    static int len, result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        len = input.length(); // 원래 문자열 길이 저장
        for(int i=0; i<len; i++) {
            char ch = input.charAt(i); // 입력값에서 문자 하나씩 분리해서
            alpha[ch-'a']++; // 해당 알파벳 문자 갯수 증가
        }

        for(int i=0; i<26; i++) {
            if(alpha[i] > 0) { // 하나라도 가지고 있는 알파벳이면
                alpha[i]--; // 갯수 줄이고
                dfs(1, i); // dfs 시작
                alpha[i]++; // 다른 조합 만들거니까 복구
            }
        }
        System.out.println(result); // 결과
    }

    static void dfs(int cnt, int nowAlpha) {
        // cnt : 현재 선택된 알파벳 갯수, nowAlpha : 현재 선택한 알파벳
        if(cnt == len) { // 원래 문자열 길이만큼 만들었으면
            result++; // 행운의 문자열 개수 증가
        }
        for(int i=0; i<26; i++) {
            // 사용할 수 있는 알파벳 문자가 있고 현재 문자와 다른거 선택하기
            if(alpha[i] > 0 && i != nowAlpha) {
                alpha[i]--; // 선택된 알파벳 갯수 줄이고
                dfs(cnt+1, i);
                alpha[i]++; // 다른 조합 만들거니까 복구
            }
        }
    }
}
