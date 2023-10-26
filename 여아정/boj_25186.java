package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_25186 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[] wear = new int[N];

		long little = 0;
		long person=0;// 사람수 카운트
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			wear[i] = Integer.parseInt(st.nextToken());
			person+=wear[i];//총 인원수 더하기
		}

		Arrays.sort(wear);

		for (int i = 0; i < N - 1; i++) {
			little += wear[i];
		}
		if ( person>1 &&wear[N - 1] > little) {//사람수가 한명 이상이며서 가장많은 옷이 나머지 옷들의 합보다 크면 무조건 겹친다!!!!!!
			System.out.println("Unhappy");//그래서 행복하지 않다 ㅠㅜ
		} else {//가장 큰 값보다 나머지 종류 값의 합이 크면 겹칠 수 없다
			System.out.println("Happy");
		}

	}

}
