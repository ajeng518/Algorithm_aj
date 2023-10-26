import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] p = new int[N];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			p[i] = sc.nextInt();
			
			// 최댓값을 구한다
			if(p[i] > max)
				max = p[i];
		}
		
		long left = max;
		long right = max*N;
		long result = 0;
		
		// 최댓값부터 범위 마지막 값까지 분할 정복으로 탐색한다.
		while(left <= right) {
      // 중간값이 K가 된다
			long mid = (left + right)/2;
			long price = mid;
			int count = 1;

      // 계산 가능한 K인지 검사한다
			for(int i=0; i<N; i++) {
				if(price < p[i]) {
					count += 1;
					price = mid;
				}
				
				price -= p[i];
				if(count > M) // M을 초과할 경우 검사를 중지한다
					break;
			}
			
			// 만약 M보다 크다면 절반 초과 범위로 이동한다
			if(count > M) {
				left = mid+1;
			}
			// 만약 M보다 작거나 같다면 절반 미만 범위로 이동한다
			else {
        // 값을 저장해 놓기 때문에, 다음 탐색이 실패해도 괜찮다
				result = mid;
				right = mid-1;
			}
		}
		
		System.out.println(result);
	}
}
