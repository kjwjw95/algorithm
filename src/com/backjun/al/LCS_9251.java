package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LCS_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aa= br.readLine();
		String bb= br.readLine();
		//int N =(aa.length()>bb.length()) ? aa.length():bb.length();
		int N=aa.length();
		int M=bb.length();
		int[][] map = new int[N+1][M+1];
		//System.out.print("  ");
		//for(int i=0;i<N;i++)
		//System.out.print(bb.charAt(i)+" ");
		//System.out.println();
		for (int i = 1; i <= N; i++) {
			int max=0;
			int a=aa.charAt(i-1);
			//System.out.print(aa.charAt(i-1)+" ");
			for (int j = 1; j <= M; j++) {
				int b=bb.charAt(j-1);
				max = (map[i-1][j]>map[i][j-1]) ? map[i-1][j]:map[i][j-1];
				if(a==b)
					max=map[i-1][j-1]+1;
				map[i][j]=max;
				//System.out.print(max+" ");
			}
			//System.out.println();
		}
		System.out.println(map[N][M]);
	}

}
