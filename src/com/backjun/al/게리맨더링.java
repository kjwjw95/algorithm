package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class 게리맨더링 {
	static int[] man;
	static int N,E,answer=Integer.MAX_VALUE;
	static int[][]map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		man = new int[N+1];
		visited=new boolean[N+1];
		map = new int[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			man[i]=Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt=Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int k =Integer.parseInt(st.nextToken());
				map[i][k]=1;
				map[k][i]=1;
			}
		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j < map[i].length; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		powerset(1);
		System.out.println(answer);
	}
	private static void powerset(int idx) {
		if(idx>N) {
			if(check(visited)) {
				int sumA=0, sumB=0;
				for (int i = 0; i < N+1; i++) {
					if(visited[i]) sumA+=man[i];
					else sumB+=man[i];
				}
				answer=Math.min(answer, Math.abs(sumA-sumB));
			}
			return;
		}
		visited[idx]=true;
		powerset(idx+1);
		visited[idx]=false;
		powerset(idx+1);
	}
	private static boolean check(boolean[] sel) {
		ArrayList<Integer> listA = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		for (int i = 0; i < sel.length; i++) {
			if(sel[i])
				listA.add(i);
			else
				listB.add(i);
		}
		if(listA.size()==0 || listB.size()==0)	return false;
		
		boolean[] selected= new boolean[N+1];
		dfs(listA,listA.get(0),visited);
		dfs(listB,listB.get(0),visited);
		
		for (int i = 0; i < selected.length; i++) {
			if(!selected[i])	return false;
		}
		
		return true;
	}
	private static void dfs(ArrayList<Integer> listA, Integer integer, boolean[] visited2) {
		// TODO Auto-generated method stub
		
	}
}
