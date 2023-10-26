import java.io.*;

public class boj2688 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			// 중복조합
			long answer = 1;
			for (int i=1; i<=9; i++) {
				answer *= (i+n);
				answer /= i;
			}

			sb.append(answer + "\n");
		}
		
		System.out.print(sb);
	}
}
