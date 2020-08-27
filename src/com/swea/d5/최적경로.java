package com.swea.d5;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 최적경로 {
	static int T, N,Ans;

	static class Point {
		public int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/최적경로.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Ans=Integer.MAX_VALUE;
			N = sc.nextInt();
			Point home = new Point(sc.nextInt(), sc.nextInt());
			Point company = new Point(sc.nextInt(), sc.nextInt());
			Point[] cus = new Point[N];
			for (int i = 0; i < N; i++) {
				cus[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			// 순열선택
			permutation(cus, new Point[cus.length], new boolean[cus.length], 0, company, home);
			//System.out.println(cnt);
			System.out.println(Ans);
		}
	}
	static int cnt;
	static int dist;
	private static void permutation(Point[] cus, Point[] sel, boolean[] visited, int idx, Point company,Point home) {
		if (idx == sel.length) {
			cnt++;
			int dist = 0;
			// 회사에서고객
			
			dist = Math.abs(company.x - sel[0].x) + Math.abs(company.y - sel[0].y);
			// 고객들방문
			for (int i = 0; i < N - 1; i++) {
				dist += Math.abs(sel[i].x - sel[i + 1].x) + Math.abs(sel[i].y - sel[i + 1].y);
			}
			// 고객집
			dist += Math.abs(sel[sel.length - 1].x - home.x) + Math.abs(sel[sel.length - 1].y - home.y);
			//System.out.println(dist);
			Ans=Math.min(Ans, dist);
			return;
		}
		for (int i = 0; i < cus.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[idx]=cus[i];
				permutation(cus, sel, visited, idx+1,company,home);
				visited[i] = false;
			}
		}
	}

}