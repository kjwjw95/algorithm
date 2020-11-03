package com.swea.모의;

import java.util.Scanner;

public class 활주로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int answer=0;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				int[] temp = new int[N];
				for (int j = 0; j < N; j++) {
					temp[j]=map[i][j];
				}
				if(FindCal(temp,X)) 
					answer++;
			}
			for (int i = 0; i < N; i++) {
				int[] temp = new int[N];
				for (int j = 0; j < N; j++) {
					temp[j]=map[j][i];
				}
				if(FindCal(temp,X)) 
					answer++;
				
			}
			System.out.println("#"+test+" "+answer);
		}
	}

	private static boolean FindCal(int[] temp, int x) {
		int privios = temp[0];
		int current =0;
		boolean[] sel = new boolean[temp.length];
		for (int i = 1; i < temp.length; i++) {
			current=temp[i];
			if(current==privios+1) {
				//만약 이전보다 높아졌다면
				for (int j = 1; j <= x; j++) {
					int next = i-j;
					if(next<0 || sel[next] || temp[next]!=privios) 
						return false;
					
					sel[next]=true;
				}
				privios=current;
			}else if(current==privios-1) {
				//이전보다 낮아졌다면
				for (int j = 1; j < x; j++) {
					int next = i+j;
					if(next>=temp.length || sel[next] || temp[next]!=current) 
						return false;
					sel[next]=true;
				}
				privios=current;
			}else if(current==privios) {
				privios=current;
			}else {
				return false;
			}
			
		}
		return true;
	}

}
