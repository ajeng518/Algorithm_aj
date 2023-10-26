import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		char[] ch = br.readLine().toCharArray();
		for (char c : ch) {
			left.add(c);
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String[] input=br.readLine().split(" ");
			String op=input[0];
			if(op.equals("P")) { // 커서 왼쪽 추가
				char c=input[1].charAt(0);
				left.add(c);
			}else if(op.equals("L")) { // 커서 왼쪽
				if(!left.isEmpty()) {
					char c=left.pop();
					right.add(c);
				}
			}else if(op.equals("D")) { // 커서 오른쪽
				if(!right.isEmpty()) {
					char c=right.pop();
					left.add(c);
				}
			}else if(op.equals("B")) { // 커서 왼쪽 삭제
				if(!left.isEmpty()) {
					left.pop();
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		while(!left.isEmpty()) { // 커서 왼쪽에 있는 문자 더하기
			sb.append(left.pop());
		}
		sb=sb.reverse();
		while(!right.isEmpty()) { // 커서 오른쪽에 있는 문자 더하기
			sb.append(right.pop());
		}
		System.out.println(sb.toString());
	}
}
