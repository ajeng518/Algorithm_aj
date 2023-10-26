import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1342 {
    static int[] alphabet; // 문자열에 쓰인 문자와 그의 개수를 저장하는 배열
    static int len; // 입력 문자열의 길이
    static int cnt; // 행운의 문자열 개수

    static void dfs(String s){
        if (len == s.length()){ // 행운의 문자열이 완성된다면,
            cnt++; // 행운의 문자열 개수를 하나 증가시켜줌
            return;
        }

        // 알파벳 순서대로 돌면서 모든 서로 다른 행운의 문자열을 만들어 감
        for(int i=0; i<27; i++){
            if (alphabet[i] == 0) continue; // 현재 이 알파벳을 사용할 수 없다면 그냥 넘김

            // 현재 쓰려고 하는 글자가 이전 글자가 같다면 이번 순서를 그냥 넘김
            if (s.length() != 0 && s.charAt(s.length()-1)==(char)('a'+i))
                continue;

            alphabet[i]--; // 문자를 사용한다는 표시
            dfs( s+(char)('a'+i)); // 현재 문자까지 추가한 문자열을 이용하여 계속해서 탐색
            alphabet[i]++; // 문자를 다시 돌려놓기(다음 순회를 위해)
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        alphabet = new int[27];
        len = input.length();
        for(int i=0; i<len; i++){
            alphabet[input.charAt(i)-'a']++;
        }

        dfs("");


        System.out.println(cnt);
    }
}
