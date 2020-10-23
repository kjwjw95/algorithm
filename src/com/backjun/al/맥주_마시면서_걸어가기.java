package com.backjun.al;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 맥주_마시면서_걸어가기 {
	static class loc {
		int x, y;

		public loc(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "loc [x=" + x + ", y=" + y + " ]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			loc house = new loc(sc.nextInt(), sc.nextInt());
			loc[] store = new loc[N];
			for (int i = 0; i < N; i++) {
				store[i] = new loc(sc.nextInt(),sc.nextInt());
			}
			loc festival = new loc(sc.nextInt(),sc.nextInt());
			
			Queue<loc> q = new LinkedList<loc>();
			q.add(house);
			boolean[] visited = new boolean[N];
			boolean isgoal = false;
			while (!q.isEmpty()) {
				loc current = q.poll();
				 System.out.println(current);
				if (Distance(festival, current) <= 1000) {
					isgoal = true;
					break;
				}
				for (int i = 0; i < store.length; i++) {
					if (Distance(store[i], current) <= 1000 && !visited[i]) {
						q.add(store[i]);
						visited[i] = true;
					}
				}
			}
			if (!isgoal)
				System.out.println("sad");
			else
				System.out.println("happy");
		}
	}

	private static int Distance(loc festival, loc current) {
		// TODO Auto-generated method stub
		return Math.abs(festival.x - current.x) + Math.abs(festival.y - current.y);
	}

}
