package com.backjun.al;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지_안녕 {
	static int R,C,T,answer;
	static int[][] map;
	static int[] airClean=new int[2];
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/미세먼지안녕.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map= new int[R][C];
		int cnt=0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1)
					airClean[cnt++]=i;
			}
		}
		//Print();
		for (int i = 0; i < T; i++) {
			Spread();
			//Print();
			Cleaned();
			//Print();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!=-1)
					answer+=map[i][j];
			}
		}
		System.out.println(answer);
	}
	private static void Cleaned() {
		int a=airClean[0];
		int b=airClean[1];
		//위에
		for (int i = a; i > 0; i--) {
			map[i][0]=map[i-1][0];
		}
		for (int i = 0; i < C-1; i++) {
			map[0][i]=map[0][i+1];
		}
		for (int i = 0; i < a; i++) {
			map[i][C-1]=map[i+1][C-1];
		}
		for (int i = C-1; i > 1; i--) {
			map[a][i]=map[a][i-1];
		}
		//아래
		for (int i = b; i < R-1; i++) {
			map[i][0]=map[i+1][0];
		}
		for (int i = 0; i < C-1; i++) {
			map[R-1][i]=map[R-1][i+1];
		}
		for (int i = R-1; i >= b; i--) {
			map[i][C-1]=map[i-1][C-1];
		}
		for (int i = C-1; i > 1; i--) {
			map[b][i]=map[b][i-1];
		}
		map[a][0]=-1;
		map[b][0]=-1;
		map[a][1]=0;
		map[b][1]=0;
	}
	private static void Spread() {
		int[][] spreadMap= new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!=0 && map[i][j]!=-1) {
					int spread=map[i][j]/5;
					int cnt=0;
					for (int k = 0; k < 4; k++) {
						int nr=i+dr[k];
						int nc=j+dc[k];
						if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]==-1)
							continue;
						spreadMap[nr][nc]+=spread;
						cnt++;
					}
					map[i][j]-=spread*cnt;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!=-1)
					map[i][j]+=spreadMap[i][j];
			}
		}
	}
	private static void Print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
