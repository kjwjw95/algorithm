package com.swea.모의;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 원자_소멸_시뮬레이션2 {
	static float[] dr = { 1, -1, 0, 0 };
	static float[] dc = { 0, 0, -1, 1 };
	static int N, Ans,Min=Integer.MAX_VALUE,Max=Integer.MIN_VALUE;
	static int[][] isCrash= new int[4001][4001];
	static int[][] loc =new int[4001][4001];
	static ArrayList<Atom> atoms;

	public static class Atom {
		public int dir, energy;
		public float row, col;
		boolean isOut;

		public Atom(int c, int r, int dir, int en) {
			this.row = r;
			this.col = c;
			this.dir = dir;
			this.energy = en;
			this.isOut = false;
		}

		@Override
		public String toString() {
			return "Atom [dir=" + dir + ", energy=" + energy + ", row=" + row + ", col=" + col + ", isOut=" + isOut + "]";
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/원자_소멸_시뮬레이션.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			Ans = 0;
			atoms= new ArrayList<Atom>();
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c=Integer.parseInt(st.nextToken());
				int r=Integer.parseInt(st.nextToken());
				Min=Math.min(c, Min);
				Min=Math.min(r, Min);
				Max=Math.max(c, Max);
				Max=Math.max(r, Max);
				atoms.add(new Atom(c, r,
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
//			for(Atom a : atoms)
//				System.out.println(a);
			Simulation();
			System.out.println("#" + test_case + " " + Ans);
		}
	}

	private static void Simulation() {
		for (int i = 0; i < (Max-Min)*2; i++) {
			int size = atoms.size();
			for (int j=0;j<size;j++) {
				float c = atoms.get(j).col + dc[atoms.get(j).dir] * 0.5f;
				float r = atoms.get(j).row + dr[atoms.get(j).dir] * 0.5f;	//이동할 row,col값
				if (c < -1000 || r < -1000 || c > 1000 || r > 1000) {
					atoms.get(j).isOut=true;
					continue;
				}
				atoms.get(j).row=r;
				atoms.get(j).col=c;	//좌표 이동
				int energy = isCrash[Toint(r)][Toint(c)];
				int location= loc[Toint(r)][Toint(c)];	//이동 한 좌표의 에너지값과 좌표 불러오기
				if (energy != 0) {	//만약 이동한 좌표의 에너지값이 0이 아니라면
					if(!atoms.get(location).isOut) {
						Ans += energy;
						atoms.get(location).isOut=true;
					}
					Ans +=atoms.get(j).energy;
					atoms.get(j).isOut=true;
				}
				isCrash[Toint(r)][Toint(c)]=atoms.get(j).energy;
				loc[Toint(r)][Toint(c)]=j;
			}
			int cnt=0;
			for (int j=0;j<size;j++) {
				isCrash[Toint(atoms.get(j-cnt).row)][Toint(atoms.get(j-cnt).col)]=0; //기존 좌표와 에너지 초기화
				loc[Toint(atoms.get(j-cnt).row)][Toint(atoms.get(j-cnt).col)]=0;
				if(atoms.get(j-cnt).isOut) {
					atoms.remove(j-cnt);
					cnt++;
				}
			}
		}
	}

	private static int Toint(float in) {
		return (int)((in+1000)*2);
	}
}