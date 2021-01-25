package com.backjun.gold;

import java.util.Scanner;
import java.util.Stack;

public class 연구소_14502 {

	static int[][] map;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static boolean[][] sel;
	static int N,M,answer=0;
	static final int wall=3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map= new int[N][M];
		sel= new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		Combination(0,0,0);
		System.out.println(answer);
	}
	public static void Combination(int cnt,int idxr,int idxc) {
		if(cnt==wall) {

			int[][] tempmap = new int[N][M];
			boolean[][] visit = new boolean[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					tempmap[i][j]=map[i][j];
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(tempmap[i][j]==2)
						BFS(i,j,tempmap,visit);
				}
			}
			int ans=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(tempmap[i][j]==0)
						ans++;
				}
			}
			answer=Math.max(answer, ans);
			return;
		}
		for(int i=idxr;i<N;i++) {
			for(int j=idxc;j<M;j++) {
				if(map[i][j]==0 && !sel[i][j]) {
					sel[i][j]=true;
			//		System.out.println(i+" : "+j);
					map[i][j]=1;
					Combination(cnt+1,(j+1==M)?i+1:i,(j+1==M)?0:j+1);
					sel[i][j]=false;
					map[i][j]=0;
				}
				idxc=0;
			}
		}
	}
	public static void BFS(int r, int c,int[][] tempmap,boolean[][] visit) {
		Stack<Integer> row= new Stack<Integer>();
		Stack<Integer> col= new Stack<Integer>();
		row.add(r);
		col.add(c);
		visit[r][c]=true;
		while(!row.isEmpty()) {
			int rr= row.pop();
			int cc= col.pop();
			for(int i=0;i<4;i++) {
				int nr=rr+dr[i];
				int nc=cc+dc[i];
				if(nr>=N || nc>=M || nr<0 || nc<0 || tempmap[nr][nc]==2 || tempmap[nr][nc]==1 || visit[nr][nc]) continue;
				tempmap[nr][nc]=2;
				visit[nr][nc]=true;
				row.add(nr);
				col.add(nc);
			}
		}
		
	}
}
