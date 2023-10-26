package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2512 {
	static int N, input[], max, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());//input 수
		input = new int[N];
		m=Integer.MIN_VALUE;//input들 중의 최대 값을 저장할 변수
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			m=Math.max(m, input[i]);

		}
		max = Integer.parseInt(br.readLine());//총예산

		System.out.println(bi_search(0, m));

	}

	private static int bi_search(int low, int high) {
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (mid > input[i])//mid값보다 작으면 input값 만큼 더한다
					sum += input[i];
				else
					sum += mid;
			}
			if (sum <= max)//sum이 max보다 작거나 같을 경우 low를 높혀준다
				low = mid + 1;
			else if (sum > max)//sum이 max보다 크면 high를 내려준다
				high = mid - 1;
		}mid = (low + high) / 2;//마지막에 한번도 mid값을 구해준다.
		return mid;
	}
}
