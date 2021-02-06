package com.backjun.gold;

import java.util.Scanner;

public class 리모컨_1107 {
	static int N,M,answer=0;
	static int[] broken,channel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		broken = new int[M];
		while(true) {
			break;
		}
		greater();
		leater();
		go();
		System.out.println(answer);
		
	}
	static public void greater() {
		
	}
	static public void leater() {
		
	}
	static public void go() {
		int temp_ans=Math.abs(N-100);
		answer=Math.min(answer, temp_ans);
	}
}
