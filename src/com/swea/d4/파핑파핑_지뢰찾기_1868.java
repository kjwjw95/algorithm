package com.swea.d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.print.attribute.standard.Fidelity;

public class 파핑파핑_지뢰찾기_1868 {
	static char[][] map;
	static int N,Answer;
	static boolean[][] sel;
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	static class Mine{
		int r,c;

		public Mine(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			Answer=0;
			map = new char[N][N];
			sel=new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String s=sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j]=s.charAt(j);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					char c = map[i][j];
					if(c=='.' && !sel[i][j] && Find0(i,j) ) {
						//System.out.println(i+" "+j);
						Answer++;
						BFS(new Mine(i, j));
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					char c = map[i][j];
					if(c=='.' && !sel[i][j]) {
						//System.out.println(i+" "+j+" ::");
						Answer++;
					}
				}
			}
			
			System.out.println("#"+test+" "+Answer);
		}
	}
	private static void BFS(Mine mine) {
		Queue<Mine> q = new LinkedList<Mine>();
		q.add(mine);
		while(!q.isEmpty()) {
			Mine m = q.poll();
			//System.out.println(":: "+m.r+" "+m.c);
			for (int i = 0; i < 8; i++) {
				int nr=m.r+dr[i];
				int nc=m.c+dc[i];
				if(nr<0 || nc<0 || nr>=N || nc>=N||sel[nr][nc])
					continue;
				if(Find0(nr,nc)) {
					sel[nr][nc]=true;
					q.add(new Mine(nr,nc));
				}
				else {
					map[nr][nc]='0';
				}
			}
		}
	}
	private static boolean Find0(int i, int j) {
		for (int k = 0; k < 8; k++) {
			int nr=i+dr[k];
			int nc=j+dc[k];
			if(nr<0 || nc<0 || nr>=N || nc>=N ||sel[nr][nc])
				continue;
			if(map[nr][nc]=='*') 
				return	false;
		}
			sel[i][j]=true;
		return true;
	}

}
