package com.swea.모의;

import java.util.Scanner;

public class 등산로_조성_1949 {
	static int N,K,max=0,ans;
	static int[][] map;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static boolean[][] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			N=sc.nextInt();
			K=sc.nextInt();
			max=0;
			ans=0;
			map=new int[N][N];
			visit=new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
					visit[i][j]=true;
					max=Math.max(max, map[i][j]);
					visit[i][j]=false;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==max)
						DFS(i,j,0);
				}
			}
		}
	}
	private static void DFS(int i, int j, int cnt) {
		for(int n=0;n<4;n++) {
			int nr=i+dr[n];
			int nc=j+dc[n];
			if(nr>=N || nc>=N || nr<0 || nc<0||visit[nr][nc])
				continue;
			visit[nr][nc]=true;
			DFS(nr, nc, cnt+1);
		}
	}

}
