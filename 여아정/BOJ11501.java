package dodo.src.cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int Test = 1; Test <= T; Test++) {

			int day = Integer.parseInt(br.readLine());
			long result = 0;
			long[] back=new long[day];//탐색

			long[] Do = new long[day];//입력받은 값 넣을 배열

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < day; i++) {
				Do[i] = Integer.parseInt(st.nextToken());
			}

			//가장 뒷 값부터 탐색 시작
			long nowMoney=Do[day-1];//가장 마지막 값으로 초기화
			int idx=day-1;//가장 마지막 인덱스로 초기화
			
			for(int i=day-2;i>=0;i--) {//뒷부분 부터 탐색시작
				if(nowMoney>Do[i]) {//현재의 값이 이전 값보다 클 경우
					back[idx]+=nowMoney-Do[i];//현재 인덱스에 차이값을 넣어준다
				}else {//현재값보다 이전 값이 크거나 같을 경우
					nowMoney=Do[i];//현재값을 갱신한다.
					idx=i;
				}
			}
			
			for(int i=0;i<day;i++) {//마지막 값 출력을 위한
				if(back[i]>0) {//차이값이 저장된 것만 골라서
					result+=back[i];//result에 더해준다
				}
			}

			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());//모든 테스트케이스의 result를 출력
	}

}
