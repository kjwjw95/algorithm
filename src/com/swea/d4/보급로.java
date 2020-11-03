package com.swea.d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보급로 {

	static class Loc{
		int r,c,val;
		public Loc(int r, int c,int val) {
			this.r=r;
			this.c=c;
			this.val=val;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for (int test = 0; test < T; test++) {
			int N=sc.nextInt();
			Queue<Loc> q = new LinkedList<Loc>();
			q.add(new Loc(0, 0, 0));
			boolean[][] sel = new boolean[N][N];
			int[][] map = new int[N][N];
			int[] dr = {1,0};
			int[] dc = {0,1};
			int ans=Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j]=(s.charAt(j)-'0');
				}
			}
			int minval=Integer.MAX_VALUE;
			while(!q.isEmpty()) {
				Loc temp = q.poll();
				//System.out.println(temp.r+" "+temp.c);
				if(temp.val>minval)
					continue;
				if(temp.r==N-1 && temp.c==N-1) {
					ans=Math.min(ans, temp.val);
					continue;
				}
				for (int i = 0; i < 2; i++) {
					int nr=temp.r+dr[i];
					int nc=temp.c+dc[i];
					if(nr<0 || nc<0 || nr>=N || nc>=N || sel[nr][nc])
						continue;
					q.add(new Loc(nr, nc, temp.val+map[nr][nc]));
					minval=Math.min(minval, map[nr][nc]+temp.val);
				}
			}
			System.out.println(ans);
		}
	}

}
