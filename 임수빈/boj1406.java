import java.io.*;
import java.util.*;

public class boj1406 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Character> answer = new LinkedList<>();
		ListIterator<Character> iter = answer.listIterator();
		
		char[] input = br.readLine().toCharArray();
		// 입력받은 문자열 정답에 추가
		for (char i: input) {
			iter.add(i);
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken(); // 명령어
			
			// 커서 왼쪽으로 옮기기
			if (order.equals("L")) {
				if (!iter.hasPrevious()) {
					continue;
				}
				iter.previous();
				continue;
			}
			
			// 커서 오른쪽으로 옮기기
			if (order.equals("D")) {
				if (!iter.hasNext()) {
					continue;
				}
				iter.next();
				continue;
			}
			
			// 문자 지우기
			if (order.equals("B")) {
				if (!iter.hasPrevious()) {
					continue;
				}
				iter.previous();
				iter.remove();
				continue;
			}
			
			// 문자 추가하기
			if (order.equals("P")) {
				char[] a = st.nextToken().toCharArray();
				
				for (char c: a) {
					iter.add(c);
				}
			}
		}
		
		// 정답 출력
		for (char ans: answer) {
			sb.append(ans);
		}
		System.out.println(sb);
	}

}
