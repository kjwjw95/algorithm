package com.backjun.gold;

import java.util.Scanner;

public class 연구소_14502 {

	static int[][] map;
	static boolean[][] sel;
	static int N,M,test=0;
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
		System.out.println(test);
	}
	public static void Combination(int cnt,int idxr,int idxc) {
		if(cnt==wall) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(sel[i][j])
						System.out.println(i+" "+j+" ");
				}
			}
			System.out.println();
			test++;
			return;
			//BFS();
		}
		for(int i=idxr;i<N;i++) {
			for(int j=idxc;j<M;j++) {
				if(map[i][j]==0 && !sel[i][j]) {
					sel[i][j]=true;
					System.out.println(i+" : "+j);
					Combination(cnt+1,(j+1==M)?i+1:i,(j+1==M)?0:j+1);
					sel[i][j]=false;
				}
				idxc=0;
			}
		}
	}
}
