import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] in = br.readLine().split("");
		Stack<String> text = new Stack<>();
		for (int i = 0; i < in.length; i++)
			text.push(in[i]);
		int M = Integer.parseInt(br.readLine());
		Stack<String> cursor = new Stack<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if (order.equals("L") && !text.isEmpty())
				cursor.push(text.pop());
			else if (order.equals("D") && !cursor.isEmpty())
				text.push(cursor.pop());
			else if (order.equals("B") && !text.isEmpty())
				text.pop();
			else if (order.equals("P")) {
				String alpha = st.nextToken();
				text.push(alpha);
			}
		}
		while (!cursor.isEmpty()) {
			text.push(cursor.pop());
		}
		StringBuilder sb = new StringBuilder();
		while (!text.isEmpty()) {
			sb.append(text.pop());
		}
		sb.reverse();
		System.out.println(sb);
	}
}
