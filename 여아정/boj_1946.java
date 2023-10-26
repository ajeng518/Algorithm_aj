package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][2];
			int min=0;
			int result=1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(map, new Comparator<int[]>() {//서류 등수 오름차순 순서로 배열 정렬

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			min=map[0][1];//서류1등의 면접 등수를 최소로 둔다
			
			for(int i=1;i<N;i++) {//면접등수를 비교하여 현재 min보다 더 작은 등 수가 나오면 값을 갱신한다
				if(map[i][1]<min) {
					result++;
					min=map[i][1];
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
