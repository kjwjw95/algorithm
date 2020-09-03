package com.swea.d4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;

class 하나로_크루스칼 {
	static int N;
	static int[] parents, locX, locY;
	static double Ans,E;
	static ArrayList<Node> node;

	static class Node implements Comparable<Node> {
		int x, y;
		double val;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.val = calcul(locX[x], locY[x], locX[y], locY[y]);
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", val=" + val + "]";
		}

		@Override
		public int compareTo(Node o) {
			double d = this.val - o.val;
			int a=0;
			if(d>0)	a=1;
			else if(d==0) a=0;
			else if(d<0)	a=-1;
			return a;
		}

	}

	static double calcul(int x1, int y1, int x2, int y2) {
		return (Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2)) * E;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/하나로.txt"));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			Ans = 0;
			parents = new int[N + 1];
			locX = new int[N + 1];
			locY = new int[N + 1];
			node = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			for (int i = 1; i <= N; i++)
				locX[i] = sc.nextInt();
			for (int i = 1; i <= N; i++)
				locY[i] = sc.nextInt();
			E = sc.nextDouble();
			MakesNode(1, 0, new int[2], new boolean[N + 1]);
			Collections.sort(node);
			int cnt=1;
			for (int i = 0; i < node.size(); i++) {
				int xx = node.get(i).x;
				int yy = node.get(i).y;
				if (Find(xx) != Find(yy)) {
					Union(xx, yy);
					Ans += node.get(i).val;
					cnt++;
					if(cnt==N)
						break;
				}
			}

			System.out.println("#"+test_case + " " + Math.round(Ans));
		}
	}

	private static void MakesNode(int idx, int cnt, int[] loc, boolean[] select) {
		if (cnt == 2) {
			node.add(new Node(loc[0], loc[1]));
			return;
		}
		for (int i = idx; i <= N; i++) {
			if (select[i])
				continue;
			loc[cnt] = i;
			select[i] = true;
			MakesNode(i + 1, cnt + 1, loc, select);
			select[i] = false;
		}
	}

	static int Find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = Find(parents[x]);
	}

	static void Union(int x, int y) {
		if (Find(x) == Find(y))
			return;
		parents[Find(y)] = Find(x);
	}
}
