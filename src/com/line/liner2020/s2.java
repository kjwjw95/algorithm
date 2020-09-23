package com.line.liner2020;

import java.util.LinkedList;

public class s2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 s = new Solution2();
		int[] b= {1, 2, 3, 4, 5, 6};
		int[] c= {6, 2, 5, 1, 4, 3};
		int[] a = s.solution(b, c);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		
	}

}
class Solution2 {
 	static LinkedList<Integer> Hold=new LinkedList<Integer>();
 	static int first=0;
 	static int last;
 	static int[] answer;
 	static int current=0;
    public int[] solution(int[] ball, int[] order) {
    	
    	last=ball.length-1;
    	answer = new int[ball.length];
    	for (int i = 0; i < order.length; i++) {
    		int o= order[i];
    		System.out.println(o+" "+first+" "+last);
    		if(ball[first]==o) {
    			answer[current++]=ball[first++];
    			FindHold(ball);
    		}else if(ball[last]==o) {
    			answer[current++]=ball[last--];
    			FindHold(ball);
    		}else {
    			Hold.add(o);
    		}
		}
        return answer;
    }
	private void FindHold(int[] ball) {
		for (Integer o : Hold) {
			if(ball[first]==o) {
    			answer[current++]=ball[first++];
    			Hold.remove(o);
    			FindHold(ball);
    			return;
    		}else if(ball[last]==o) {
    			answer[current++]=ball[last--];
    			Hold.remove(o);
    			FindHold(ball);
    			return;
    		}
		}
	}
}