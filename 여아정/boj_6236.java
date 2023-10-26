package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6236 {
	static int n,m,result;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		result=0;

		int max=Integer.MIN_VALUE;
		int[] input=new int[n];
		
		for(int i=0;i<n;i++) {
			input[i]=Integer.parseInt(br.readLine());
			max=Math.max(max, input[i]);
		}

		int end=10000 * 100000;//큰값에서 탐색 시작
		int start=max;//탐색 시작값을 max로 둠
		int ans=binary_search(start, end, input);

		System.out.println(ans);
		
	}
	
	private static int search_money(int money, int[] input) {
		int today=money;
		int cnt=1;

		for(int i=0;i<input.length;i++) {//인출 횟수 체크
			if(today>=input[i]) {
				today-=input[i];
			}else {
				cnt++;
				today=money;
				today-=input[i];
			}
		}
		return cnt;
	}
	
	
	private static int binary_search(int start, int end, int[] input) {
		int mid=0;
		
		while(start<=end) {//이분 탐색
			mid=(start+end)/2;

		if(search_money(mid, input)<=m) {//인출 횟수가 목표 횟수보다 작거나 같으면 해당금액으로 생각
				result=mid;
				end=mid-1;
			}
			else if(search_money(mid, input)>m){
				start=mid+1;
			}
		}
		
		return result;
	}

}
