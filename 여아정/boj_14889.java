package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889 {
	static int N, map[][], result[], power[], min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		min = Integer.MAX_VALUE;
		
		//입력 받기
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		result = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		team(0, 0);//함수 시작
		
		System.out.println(min);//최소값 출력

	}

	private static void team(int cnt, int now) {//팀 가능한 경우 조합으로 뽑기
		if (cnt == N / 2) {
			power = new int[2];
			int sum = sumPower();//각 팀의 능력치 더하는 함수로 능력치 차이값 반환 받는다
			if (min > sum) {//이전의 최소값보다 더 작은 값일 경우
				min = sum;//최소값을 업데이트 해준다.
			}

			return;
		}

		for (int i = now; i < N; i++) {
			result[i] = 1;//1넣기
			team(cnt + 1, i + 1);
			result[i] = 0;//아닌 경우 0넣기

		}
	}

	private static int sumPower() {//각 팀 마다의 능력치 더하기

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (result[i] == 1 && result[j] == 1) {//1인 팀의 능력치 더하기
					power[1] += map[i][j];
					power[1] += map[j][i];
				} else if (result[i] == 0 && result[j] == 0) {//0인 팀의 능력치 더하기
					power[0] += map[i][j];
					power[0] += map[j][i];
				}
			}
		}
		//각 팀의 능력치의 차를 return 해준다
		return power[0] > power[1] ? power[0] - power[1] : power[1] - power[0];
	}
}
