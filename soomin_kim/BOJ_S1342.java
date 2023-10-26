import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_S1342 {
    static int count;
    static String word;
    static List<String> answer;

    static int[] alphabet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();

        //입력 받을 떄 각 문자의 갯수를 세기
        alphabet = new int[26];

        for(int i = 0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            alphabet[index]++;
        }

        //행복 문자열인줄 알고 happy라고 했읍니다...
        happy(""); //순열 찾기~~
        System.out.println(count);
    }

    public static void happy(String happyWord) {

        //기저 조건: 입력받은 문자열 길이와 행운의 문자열 길이가 같으면 return
        if (happyWord.length() == word.length()) {
            count++;
            return;
        }

        // 입력받은 알파벳을 돌면서 행운의 문자열 찾기
        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] >= 1) { // 입력바은 알파벳일 댸
                if (!happyWord.equals("") && happyWord.charAt(happyWord.length() - 1) == (char) (i + 'a')) continue; //인접한 문자가 겹칠때는 continue
                alphabet[i]--; //방문 표시
                happy(happyWord + (char) (i + 'a')); // 순열을 찾아 떠나요
                alphabet[i]++; // 방문했던 거 지워주기
            }
        }
    }
}
