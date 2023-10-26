import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1342 {

	public static boolean[] visit;
	public static char[] alpha;
	public static int cnt, len;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		alpha = br.readLine().toCharArray();
		len = alpha.length;
		visit = new boolean[len];
		cnt = 0;
		sb=new StringBuilder();
		
		permutation(0);
		System.out.println(cnt);
	}

	public static void permutation(int idx) {
		if (idx == len) {
			cnt++;
			return;
		}
		boolean[] visit_alpha=new boolean[26]; // 알파벳 방문했는가
		for (int i = 0; i < len; i++) {
			if(visit_alpha[alpha[i]-'a']) continue; // 이미 방문한 알파벳
			if (!visit[i]) { // 아직 방문안함
				if (idx != 0 && sb.charAt(idx - 1) == alpha[i]) // 행운의 문자열x
					continue;
				visit_alpha[alpha[i]-'a']=true;
				visit[i] = true;
				sb.append(alpha[i]);
				permutation(idx + 1);
				sb.deleteCharAt(sb.length()-1);
				visit[i] = false;
			}
		}
	}
}
