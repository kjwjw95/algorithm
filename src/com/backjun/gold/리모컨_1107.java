package com.backjun.gold;

import java.util.ArrayList;
import java.util.Scanner;

public class 리모컨_1107 {
	static int N,M,answer=0,dec;
	static int[] broken;
	static ArrayList<Integer> channel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		broken = new int[M];
		channel = new ArrayList<Integer>();
		while(true) {
			if(N==0)
				break;
			channel.add(N%10);
			N/=10;
		}
		dec=channel.size();
		greater();
		leater();
		go();
		System.out.println(answer);
		
	}
	static public void greater() {
		boolean isUp=false;
		int temp_ans;
		if(isUp) {
			
		}
	}
	static public void leater() {
		
	}
	static public void go() {
		int temp_ans=Math.abs(N-100);
		answer=Math.min(answer, temp_ans);
	}
}
