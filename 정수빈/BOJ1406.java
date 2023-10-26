import java.util.*;
import java.io.*;

public class BOJ1406 {
	static int N, M;
	static Stack<Character> left, right;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// 커서를 중심으로 하는 왼쪽 스택, 오른쪽 스택
		left = new Stack<>();
		right = new Stack<>();
		
		for(char c : br.readLine().toCharArray())
			left.push(c);
		
		N = left.size();
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char command = st.nextToken().charAt(0);
			
			// 커서 명령어
			switch(command) {
			case 'L': // 왼쪽으로 한 칸 이동
				if(!left.isEmpty())
					right.push(left.pop());
				break;
			case 'D': // 오른쪽으로 한 칸 이동
				if(!right.isEmpty())
					left.push(right.pop());
				break;
			case 'B': // 왼쪽 문자를 삭제
				if(!left.isEmpty())
					left.pop();
				break;
			default: // 왼쪽에 문자를 추가
				char c = st.nextToken().charAt(0);
				left.push(c);
			}
		}
		
		// StringBuilder 에 담아서 출력한다
		while(!left.isEmpty())
			sb.append(left.pop());
		sb.reverse();

		while(!right.isEmpty())
			sb.append(right.pop());
		
		System.out.println(sb.toString());
	}
}
