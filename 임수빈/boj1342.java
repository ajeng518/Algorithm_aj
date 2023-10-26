import java.io.*;

public class boj1342 {

    static int size;
    static int answer = 0;
    static int[] visited = new int[27];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열
        String s = br.readLine();

        // 문자열 길이
        size = s.length();

        // 알파벳 개수 저장
        for (int i=0; i<size; i++) {
            visited[s.charAt(i) - 'a']++;
        }

        find(0, "");
        System.out.println(answer);
    }

    static void find(int cnt, String result) {
        // 문자열이 만들어진 경우
        if (cnt == size) {
            answer++;
            return;
        }

        for (int i=0; i<26; i++) {
            // 쓸 수 있는 알파벳이 아닌 경우
            if (visited[i] == 0) {
                continue;
            }

            int resLen = result.length();
            char temp = (char)(i + 'a');

            // 앞의 문자가 현재 문자와 같으면 넘어간다. (행복 문자열이 아님)
            if (resLen > 0 && result.charAt(resLen-1) == temp) {
                continue;
            }

            visited[i]--;
            find(cnt+1, result + temp); // 문자 붙이기
            visited[i]++;
        }
    }
}
