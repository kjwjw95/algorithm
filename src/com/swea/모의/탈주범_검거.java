package com.swea.모의;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈주범_검거 {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] canGo= new boolean[4][8];
	/*
	 * 0:위
	 * 1:오른쪽
	 * 2:아래
	 * 3:왼쪽
	 * 
	 */
	
	static class Loc{
		int r,c,step;

		public Loc(int r, int c,int step) {
			super();
			this.r = r;
			this.c = c;
			this.step=step;
		}
		
	}
	static class Pipe{
		int type;
		boolean[] hole = new boolean[4];
		public Pipe(int type) {
			this.type = type;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		Pipe[] pipes = new Pipe[8];
		for (int i = 1; i < pipes.length; i++) {
			pipes[i]= new Pipe(i);
		}
		
		pipes[1].hole[0]=true;
		pipes[1].hole[1]=true;
		pipes[1].hole[2]=true;
		pipes[1].hole[3]=true;
		
		pipes[2].hole[0]=true;
		pipes[2].hole[2]=true;
		
		pipes[3].hole[1]=true;
		pipes[3].hole[3]=true;
		
		pipes[4].hole[0]=true;
		pipes[4].hole[1]=true;
		
		pipes[5].hole[1]=true;
		pipes[5].hole[2]=true;
		
		pipes[6].hole[3]=true;
		pipes[6].hole[2]=true;
		
		pipes[7].hole[0]=true;
		pipes[7].hole[3]=true;
		
		
		canGo[0][1]=true;
		canGo[0][2]=true;
		canGo[0][5]=true;
		canGo[0][6]=true;
		
		canGo[1][1]=true;	//오른쪽
		canGo[1][3]=true;
		canGo[1][6]=true;
		canGo[1][7]=true;
		
		canGo[2][1]=true;	//아래		
		canGo[2][2]=true;
		canGo[2][4]=true;
		canGo[2][7]=true;
		
		canGo[3][1]=true;	//왼쪽
		canGo[3][3]=true;
		canGo[3][4]=true;
		canGo[3][5]=true;
		
		for (int test = 1; test <= T; test++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int R=sc.nextInt();
			int C=sc.nextInt();
			int L=sc.nextInt();
			boolean[][] visit = new boolean[N][M];
			int answer=1;
			int[][] map =new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			Queue<Loc> q = new LinkedList<Loc>();
			q.add(new Loc(R,C,1));
			visit[R][C]=true;
			while(!q.isEmpty()) {
					Loc defector = q.poll();
					if(defector.step==L)
						break;
					int pipe = map[defector.r][defector.c];
					for (int j = 0; j < 4; j++) {
						int nr=defector.r+dr[j];
						int nc=defector.c+dc[j];
						if(nr<0 || nc<0 || nr>=N || nc>=M || visit[nr][nc] || map[nr][nc]==0)
							continue;
						if(!pipes[pipe].hole[j] || !canGo[j][map[nr][nc]])
							continue;
						visit[nr][nc]=true;
						q.add(new Loc(nr,nc,defector.step+1));
						answer++;
					}
			}
			System.out.println("#"+test+" "+answer);
		}
	}

}
