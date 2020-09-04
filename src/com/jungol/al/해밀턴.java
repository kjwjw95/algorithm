package com.jungol.al;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 해밀턴 {
	static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/해밀턴.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][N+1];
		boolean[] select = new boolean[N+1];
		int[] cost = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 1; j < map.length; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		Print(map);
		for (int i = 1; i <= N; i++) {
			cost[i]=Integer.MAX_VALUE;
		}
		select[1]=true;
		cost[1]=0;
		
		for (int i = 1; i <= N; i++) {
			if(!select[i] && map[1][i]!=0) {
				cost[i]=map[1][i];
			}
		}
		for (int i = 1; i < N; i++) {
			int min=Integer.MAX_VALUE;
			int min_idx=-1;
			for (int j = 1; j <= N; j++) {
				if(!select[j] && cost[j]!=Integer.MAX_VALUE) {
					if(cost[j]<min) {
						min=cost[j];
						min_idx=j;
					}
				}
			}
			select[min_idx]=true;
			for (int j = 1; j <= N; j++) {
				if(!select[j] && map[min_idx][j]!=0) {
					if(cost[j]>cost[min_idx]+map[min_idx][j])
						cost[j]= cost[min_idx]+map[min_idx][j];
				}
			}
//			if(cost[N+1]>cost[min_idx]+map[min_idx][1])
//				cost[N+1]=cost[5]+map[min_idx][1];
			for (int j = 1; j < cost.length; j++) {
				System.out.print(cost[j]+" ");
			}
			System.out.println(" , "+min_idx);
		}
//		int answer=Integer.MAX_VALUE;
//		for (int i = 0; i < cost.length; i++) {
//			answer
//		}
		
	}


	private static void Print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
