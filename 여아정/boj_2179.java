package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_2179 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (list.contains(str))// 중복된 값이 있으면 넣지 않음
				continue;
			list.add(str);
		}

		int first = 0;
		int second = 0;
		int maxLen = 0;// 최대 길이

		// 완탐 돌기
		for (int i = 0; i < N - 1; i++) {
			String str1 = list.get(i);
			for (int j = i + 1; j < N; j++) {
				String str2 = list.get(j);
				int len = str1.length() > str2.length() ? str2.length() : str1.length();// 길이 작은 것을 기준으로 비교
				int cnt = 0;
				for (int k = 0; k < len; k++) {
					if (str1.charAt(k) != str2.charAt(k))// 서로 알파벳이 같지 않으면 카운트 멈추기
						break;
					cnt++;
				}
				if (cnt > maxLen) {// 현재 max보다 더 같은 부분cnt가 더 많다면
					// 값 갱신해주기
					first = i;
					second = j;
					maxLen = cnt;
				}
			}
		}
		sb.append(list.get(first)).append("\n").append(list.get(second));
		System.out.println(sb);

	}
}
