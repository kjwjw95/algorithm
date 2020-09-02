package com.swea.모의;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 원자_소멸_시뮬레이션 {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, Ans, Min = Integer.MAX_VALUE, Max = Integer.MIN_VALUE;
	static int[][] loc = new int[4001][4001];
	static Atom[] atoms;

	public static class Atom {
		public int dir, energy;
		public int row, col;
		boolean isOut,isCrush;

		public Atom(int c, int r, int dir, int en) {
			this.row = r;
			this.col = c;
			this.dir = dir;
			this.energy = en;
			this.isOut = false;
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/원자_소멸_시뮬레이션.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			Ans = 0;
			N = Integer.parseInt(br.readLine());
			atoms = new Atom[N];
			loc = new int[4001][4001];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c = Toint(Float.parseFloat(st.nextToken()));
				int r = Toint(Float.parseFloat(st.nextToken()));
				Min = Math.min(c, Min);
				Min = Math.min(r, Min);
				Max = Math.max(c, Max);
				Max = Math.max(r, Max);
				atoms[i] = new Atom(c, r, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Simulation();
			System.out.println("#" + test_case + " " + Ans);
		}
	}

	private static void Simulation() {
		int length=atoms.length;
		for (int i = 0; i < (Max-Min)*2; i++) {
			for (int j = 0; j < length; j++) {
				if(atoms[j].isOut)	continue;
				int c = atoms[j].col + dc[atoms[j].dir];
				int r = atoms[j].row + dr[atoms[j].dir]; // 이동할 row,col값
				if (c < -1000 || r < -1000 || c > 1000 || r > 1000) {
					atoms[j--]=atoms[--length];
					if(length==0)	break;
					continue;
				}
				atoms[j].row = r;
				atoms[j].col = c; // 좌표 이동
				int location = loc[r][c]-1; // 이동 한 좌표의 에너지값과 좌표 불러오기
				if (location >=0 && atoms[location].energy != 0) { // 만약 이동한 좌표의 에너지값이 0이 아니라면
					atoms[location].isCrush = true;
					atoms[j].isCrush = true;
				}
				loc[r][c] = j+1;
			}
			for (int j=0;j<length;j++) {
				if(length==0)	break;
				loc[atoms[j].row][atoms[j].col] = 0;
				if (atoms[j].isCrush) {
					Ans+=atoms[j].energy;
					atoms[j].isCrush=false;
					atoms[j--]=atoms[--length];
				}
			}
		}
	}

	private static int Toint(float in) {
		return(int)( (in + 1000) * 2);
	}
}