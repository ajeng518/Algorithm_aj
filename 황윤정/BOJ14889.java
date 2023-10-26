import java.io.*;
import java.util.*;

public class BOJ14889 {
	static int N, result=Integer.MAX_VALUE;
	static boolean[] visited; // 한쪽팀 선택하고 남은 팀원 바로 고르기 위한 배열
	static int[][] arr; // 
	static int[] start, link; // 스타트팀, 링크팀 팀원
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		start = new int[N/2];
		link = new int[N/2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. N/2 만큼 스타트팀원 조합으로 구하고, 남은건 링크팀에 채우기
			// 한쪽팀원 정했으면, 다른 팀은 boolean 배열 참고해서 남은 번호 바로 채우기
		// 2. 각 팀 배열에서 2개씩 고르는 순열 함수 돌리고, 2명의 능력치 구하기
		// 3. 반복해서 팀별 총 능력치 구하고 절댓값으로 차이 구해서 최솟값 갱신
		combi(0, 0);
		System.out.println(result);
	}
	
	static void combi(int cnt, int idx) {
		// 팀원 다 정한 경우
		if(cnt == N/2) {
			// 스타트팀 뽑고 남은 수로 링크팀 멤버 구하기
			int linkCnt=0;
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					link[linkCnt++] = i;
				}
			}
			// 팀별 능력치 구하러가기
			int startPower = getTeamPower(0, 0, new int[2], start);
			int linkPower = getTeamPower(0, 0, new int[2], link);
			// 팀 능력치 차이 최솟값
			result = Math.min(result, Math.abs(startPower - linkPower));
			return;
		}
		// 조합으로 스타트팀 팀원 정하기
		for(int i=idx; i<N; i++) {
			start[cnt] = i;
			visited[i] = true;
			combi(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	static int getTeamPower(int cnt, int start, int[] choice, int[] team) {
		// cnt: 조합으로 뽑은 갯수, start: 조합 시작, choice: 능력치 구할 팀원 쌍, team: 현재 팀
		int sum=0;
		if(cnt == 2) { // 팀 내 2명 뽑았으면
			sum += arr[choice[0]][choice[1]]; // 능력치 구하기
			sum += arr[choice[1]][choice[0]];
			return sum;
		}
		for(int i=start; i<N/2; i++) { // 조합으로 한 팀에서 능력치 구할 2명 뽑기
			choice[cnt] = team[i];
			sum += getTeamPower(cnt+1, i+1, choice, team);
		}
		return sum; // 해당 팀의 총 능력치
	}
}
