package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2841 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 기타 줄마다의 스택을 할당 했습니다.
		Stack<int[]> stk1 = new Stack<>();
		Stack<int[]> stk2 = new Stack<>();
		Stack<int[]> stk3 = new Stack<>();
		Stack<int[]> stk4 = new Stack<>();
		Stack<int[]> stk5 = new Stack<>();
		Stack<int[]> stk6 = new Stack<>();

		// 입력받아줍니다
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[][] play = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			play[i][0] = Integer.parseInt(st.nextToken());
			play[i][1] = Integer.parseInt(st.nextToken());
		}

		// 정답으로 넣을 move를 0으로 초기화 해줍니다
		int move = 0;

		for (int i = 0; i < N; i++) {// input 값 만큼 반복을 돕니다
			int nowx = play[i][0];
			int nowy = play[i][1];

			if (nowx == 1) {// 각각 몇번째 기타 줄인지 확인합니다
				move += gitt(nowx, nowy, stk1);// 함수로 보냅니다
			} else if (nowx == 2) {
				move += gitt(nowx, nowy, stk2);
			} else if (nowx == 3) {
				move += gitt(nowx, nowy, stk3);
			} else if (nowx == 4) {
				move += gitt(nowx, nowy, stk4);
			} else if (nowx == 5) {
				move += gitt(nowx, nowy, stk5);
			} else if (nowx == 6) {
				move += gitt(nowx, nowy, stk6);
			}
		}
		System.out.println(move);// 최종 결과 입력합니다
	}

	
	private static int gitt(int nowx, int nowy, Stack<int[]> stk) {
		int cnt = 0;//

		while (!stk.isEmpty()) {// 스택에 값이 존재한다면

			int[] tmp = stk.peek();

			if (tmp[1] < nowy) {// 기존 값이 현재 값보다 적다면
				stk.push(new int[] { nowx, nowy });// 넣어줌
				cnt++;// 손가락 이동++
				break;
			} else if (tmp[1] > nowy) {// 기존값이 현재 값보다 크다면
				stk.pop();// 기존값을 없애준다
				cnt++;// 손가락 이동++
			} else if (tmp[1] == nowy)// 값이 같다면
				break;// 넘어감
		}
		if (stk.isEmpty()) {// 비었을땐
			stk.push(new int[] { nowx, nowy });// 그냥 넣음
			cnt++;// 손가락 이동++
		}
		return cnt;// cnt 개수로 반환해준다
	}
}

