import java.util.*;

public class BOJ1342 {
    static ArrayList<Character> lst;
    static int count, length, alpha[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 어떤 문자열들이 있는지 저장 (중복 제거)
        lst = new ArrayList<>();

        // 해당 문자열은 몇 번 사용 가능한지 저장
        alpha = new int[26];
        length = 0;

        for(char c : sc.next().toCharArray()) {
            if(!lst.contains(c))
                lst.add(c);

            alpha[(int)c-97] += 1;
            length += 1;
        }

        count = 0;

        dfs(0, /*-1,*/ -1);

        System.out.println(count);
    }

    static void dfs(int size, /*int prepre, */int pre) {
        if(size == length) {
            count += 1;
            return;
        }

        for(int i=0; i<lst.size(); i++) {
            // 해당 문자의 인덱스를 소환
            int n = lst.get(i)-97;

            // 해당 문자열을 사용할 수 있는지 확인
            if(alpha[n] == 0) {
                continue;
            }

            // 전 인덱스와 같은지 비교
            if(size>=1 && pre == n) {
                continue;
            }

//            // 전전 인덱스와 같은지 비교
//            if(size>=2 && prepre == n) {
//                continue;
//            }

            // 위 과정을 다 통과했으면 재귀
            alpha[n] -= 1;
            dfs(size+1, /*pre,*/ n);
            alpha[n] += 1;
        }
    }
}
