package com.nhn.nhnTest;

import java.util.List;

public class hack_test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int balancedSum(List<Integer> arr) {
	    // Write your code here
		int N =arr.size();
		int sum=arr.get(N-1);
		for(int n : arr) {
			int a=n;
		}
	        return 0;
	    }
	
	public static String lastLetters(String word) {
	    // Write your code here
			int N = word.length();
			char a = word.charAt(N-1);
			char b = word.charAt(N-2);
			String s = a+" "+b;
			return s;
	    }
	
	int isPrime(long n) {
		int i=2;
		int[] str = new int[5];
		while(true) {
			if(n%i++!=0)
				return i;
			if(n==i)
				return 1;
		}
	}
}
