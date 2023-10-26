import java.io.*;
import java.util.*;

public class BOJ1406 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String input = br.readLine();
		Deque<Character> deque = new ArrayDeque<>(); // 문자열을 저장하는 덱
		Stack<Character> stack = new Stack<>(); // 커서의 움직임에 따라 문자를 옮겨두는 스택
		for(int i=0; i<input.length(); i++) {
			deque.offer(input.charAt(i));
		}
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			char inst = st.nextToken().charAt(0);
			
			switch(inst) {
			case 'L': // 왼쪽으로 커서 이동
				if(!deque.isEmpty()) {
					char ch = deque.pollLast(); 
					stack.push(ch); // 덱의 마지막 문자를 스택으로 옮김
				}
				break;
			case 'D': // 오른쪽으로 커서 이동
				if(!stack.isEmpty()) {
					char ch = stack.pop();
					deque.offerLast(ch); // 스택의 마지막 문자를 덱으로 옮김
				}
				break;
			case 'B': // 커서 왼쪽의 문자 삭제
				if(!deque.isEmpty()) {
					deque.pollLast(); // 덱의 마지막 문자를 삭제
				}
				break;
			case 'P': // 커서 왼쪽에 문자 추가
				char ch = st.nextToken().charAt(0);
				deque.offerLast(ch); // 입력받은 문자를 덱의 마지막에 저장
				break;
			}
		}
		while(!stack.isEmpty()) {
			char ch = stack.pop(); // 스택에 남아있는 문자를 모두 덱으로 합침
			deque.offerLast(ch);
		}
		while(!deque.isEmpty()) {
			sb.append(deque.pollFirst()); // 덱의 첫번째 문자부터 빼내서 출력값 저장
		}
		System.out.println(sb.toString());
	}
}
