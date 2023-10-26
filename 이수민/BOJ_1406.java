import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ_1406 {
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new LinkedList<>();
        ListIterator<Character> iterator = list.listIterator();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        // 초기 문자열 list에 저장
        for(char c : br.readLine().toCharArray()) {
            iterator.add(c);
        }

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken().charAt(0)) {
                case 'L': // 커서 왼쪽으로 한 칸 옮김
                    if (iterator.hasPrevious()) iterator.previous();
                    break;
                case 'D': // 커서 오른쪽으로 한 칸 옮김
                    if (iterator.hasNext()) iterator.next();
                    break;
                case 'B': // 커서 왼쪽에 있는 문자를 삭제
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P': // 문자를 커서 왼쪽에 추가
                    char c = st.nextToken().charAt(0);
                    iterator.add(c);
            }
        }

        for(char c : list) sb.append(c);
        System.out.println(sb);

    }
}
