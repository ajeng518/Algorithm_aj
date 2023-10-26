package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_16113 {
	static String[] num = new String[10];
	static char[][] number = new char[10][15];
	static char[][] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();// 먼저 1차원 배열에 input을 받는다
		arr = new char[5][N / 5];// 입력받을 문자열(5행인 2차원 배열에 넣는다)

		initial();// 초기 설정해주기(알아둘 숫자들의 문자열들을 저장)

		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = input[idx++];// 1차원배열의 input값을 2차원 바열로 저장
			}
		}

		for (int i = 0; i < N / 5;) {// 가장 윗줄만 탐색
			if (arr[0][i] == '#') {// 현재 값이 #이라면
				int flag = isItNumber(i);// 숫자가 되는 지 탐색
				if (flag > -1) {// 유효한 숫자라면
					sb.append(flag);// 스트링빌더에 넣어준다
					if (flag == 1) {// 1 값이면
						i += 2;
					} else {// 1이아닌 숫자일 경우
						i += 3;
					}
				} else {// #이 아닐경우
					i++;
				}
			} else {// #이 아닐경우
				i++;
			}
		}

		System.out.println(sb.toString());// 결과 출력
	}

	private static void initial() {// 초기 숫자 문자를 저장
		// 1은 저장하지 않음
		num[0] = "####.##.##.####";
		num[2] = "###..#####..###";
		num[3] = "###..####..####";
		num[4] = "#.##.####..#..#";
		num[5] = "####..###..####";
		num[6] = "####..####.####";
		num[7] = "###..#..#..#..#";
		num[8] = "####.#####.####";
		num[9] = "####.####..####";

		for (int i = 0; i < 10; i++) {
			if (i == 1)
				continue;
			number[i] = num[i].toCharArray();// string의 num을 char의 num으로 변환
		}
	}

	private static int isItNumber(int start) {// 숫자가 맞는지 탐색
		int Flag = isOne(start);// 먼저 1인지 판단
		if (Flag > -1) {
			return Flag;// 1으로 판단하고 반환
		}

		int idx = 0;
		boolean nextGo = false;

		for (int i = 0; i < 10; i++) {// 기존에 기억하는 숫자값들과 현재값을 비교
			if (i == 1)
				continue;
			idx = 0;
			nextGo = false;// 다음으로 넘어갈 것을 표시하는 flag값
			for (int j = 0; j < 5; j++) {// 행 5
				for (int k = start; k < start + 3; k++) {// 열3
					if (arr[j][k] != number[i][idx]) {
						nextGo = true;// 해당 숫자가 아니므로 다음 숫자 탐색을 하라는 flag
						break;
					}
					idx++;
				}
				if (nextGo == true) {
					break;
				}
			}
			if (nextGo == false) {// 모든 문자가 맞다면!!
				// i가 맞는 수
				return i;
			}
		}
		return -1;
	}

	private static int isOne(int start) {// 1인지 판단하는 함수
		int cnt = 1;
		for (int i = start + 1; i < start + 3 && i < N / 5; i++) {// 현재+1부터 2만큼 가장 윗값 탐색
			if (arr[0][i] == '#') {
				cnt++;
			}
		}
		if (cnt == 2 || cnt == 1) {// 다른 수는 열 크기가 3이지만 1은 열 크기가 1이므로 그 다음 수가 3안에 있을 수 있음
			int zero = 0;
			for (int i = 0; i < 5; i++) {// 1은 행 5개가 다 #이어야 하므로 확인하-ㅐ보기
				if (arr[i][start] == '#')
					zero++;
			}
			if (zero == 5) {// 다섯 행 모드 #이라면 1인 값!!
				return 1;
			}
		}
		return -1;// 아닐 경우 -1

	}

}
