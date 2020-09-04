package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최단경로 {
	static int ans[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(br.readLine());
		int[][] map = new int[V+1][V+1];
		boolean[] connect = new boolean[V+1];
		ans = new int[V+1];
		connect[K]=true;
		for (int i = 0; i < E; i++) {
			st= new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			map[r][c]=cost;
		}
		Print(map);
		int answer=Prime(map,connect,0,1);
		for (int i = 1; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		//System.out.println(answer);
	}

	private static int Prime(int[][] map, boolean[] connect, int value, int cnt) {
		// TODO Auto-generated method stub
		if(cnt==connect.length) {
			return value;
		}
		int next=-1;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < connect.length; i++) {
			if(connect[i]) {
				for (int j = 1; j < map.length; j++) {
					if(!connect[j] && map[i][j]!=0 && min>map[i][j]) {
						next=j;
						min=map[i][j];
					}
				}
			}
		}
		if(next==-1)
			return value;
		connect[next]=true;
		value+=min;
		ans[next]=min;
		cnt++;
		for (int i = 1; i < ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
		return Prime(map, connect, value, cnt);
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
