package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		char[] input = br.readLine().replace(" ", "").toCharArray();

		long result = 0;

		int idx = 0;
		int Is = 0;// I로 갱신했는지 구분하는 flag 값
		int size = 2*N+1;//구하고자 하는 Pn의 크기

		int[] stend = new int[2];

		while (idx < S) {
			if (Is == 0 && input[idx] == 'I') {// 시작 초기 조건 만족 확인용
				Is = 1;
				stend[0] = idx;
				stend[1] = 0;
				idx++;
				continue;
			}
			if (Is == 1) {// 초기 I값을 찾았을 때

				if (input[idx] == input[idx - 1]) {// 이전 값이랑 같은 문자 라면
					if (input[idx - 1] == 'I') {// 이전값과 현재값이 I라면
						stend[1] = idx - 1;// 이전값 인덱스를 갱신
					} else {// 이전값과 현재값이 O라면
						stend[1] = idx - 2;// 현재-2 인덱스를 갱신
					}
					if (stend[1] - stend[0] + 1 >= size) {// IOIO...범위가 구하고자하는 Pn크기보다 큰경우만 카운트 실행
						result += sumCnt(stend, N);
					}

					Is = 0;// 다시 I를 찾기 위해 0으로 세팅
					continue;
				} else if (idx == S - 1) {//마지막 까지 진행했는 경우
					if (input[idx] == 'I') {//마지막 값이 I일 경우
						stend[1] = idx;
					} else {//마지막 값이 O로 끝나는 경우 => O로 끝나면 카운트에 제대로된 계산이 나오지 않음
						// 이전값을 넣어준다.
						stend[1] = idx - 1;
					}

					// IOIO...범위가 구하고자하는 Pn크기보다 큰경우만 카운트 실행
					if (stend[1] - stend[0] + 1 >= size) {
						result += sumCnt(stend, N);
					}

					break;
				}
			}
			idx++;
		}

		System.out.println(result);
	}

	private static int sumCnt(int[] stend, int n) {
		//Pn 카운트 해주기 (IOI...끝 인덱스 -시작 인덱스)에서 Pn사이즈를 뺴서 갯수 계산하기

		return (stend[1] - stend[0] - (2 * n)) / 2 + 1;
	}

}
