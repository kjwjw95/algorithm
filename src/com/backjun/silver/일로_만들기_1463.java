package com.backjun.silver;

import java.util.Scanner;

public class 일로_만들기_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer=0;
		int[] dp = new int[1000001];
		//dp[n]=1;
		for(int i=n;i>0;i--) {
			int temp = dp[i];
			if(i%3==0 && (dp[i/3]>dp[i]||dp[i/3]==0)) {
				dp[i/3]=temp+1;
			}
			if(i%2==0 && (dp[i/2]>dp[i]||dp[i/2]==0)) {
				dp[i/2]=temp+1;
			}
			if(dp[i-1]>dp[i] ||dp[i-1]==0) {
				dp[i-1]=temp+1;
			}
		}
		System.out.println(dp[1]);
	}

}
