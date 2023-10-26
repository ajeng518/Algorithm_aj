package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11000 {
	static class Room implements Comparable<Room> {
		int start;
		int end;

		public Room() {
			super();
		}

		public Room(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Room o) {
			if (start == o.start)
				return end - o.end;
			return start - o.start;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Room[] lecture = new Room[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lecture[i] = new Room(start, end);
		}

		long max = 0;
		Arrays.sort(lecture);
		pq.add(lecture[0].end);
		
		for(int i=1;i<N;i++){
			if (pq.peek()<=lecture[i].start)
				pq.poll();
			pq.add(lecture[i].end);
		}
		
		System.out.println(pq.size());
	}

}
