import java.util.*;
import java.io.*;

public class BOJ_S1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split("");
        int m = Integer.parseInt(br.readLine());

        Stack<String> left = new Stack<>();

        for(String s:str) {
            left.add(s);
        }

        Stack<String> right = new Stack<>();

        for(int i = 0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            if(line[0].equals("P")) { // 커서 왼쪽에 문자열을 추가하는 명령어일 경우
                left.add(line[1]);
            }
            else if(line[0].equals("L")) { // 커서를 왼쪽으로 옮김
                if(!left.isEmpty())
                    right.add(left.pop());
            }
            else if(line[0].equals("D")) { // 커서를 오른쪽으로 옮김
                if(!right.isEmpty())
                    left.add(right.pop());
            }
            else if(line[0].equals("B")) { // 지움
                if(!left.isEmpty())
                    left.pop();
            }
        }

        //커서 오른쪽에 남은 문자가 있다면 왼쪽 stack에 옮겨준다.
        if(!right.isEmpty()) {
            while(!right.isEmpty()) {
                left.add(right.pop());
            }
        }

        // stack의 문자들을 다꺼내서 reverse해준다.
        while(!left.isEmpty()) {
            sb.append(left.pop());
        }
        sb.reverse();

        System.out.println(sb);

    }
}