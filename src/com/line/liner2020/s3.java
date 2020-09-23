package com.line.liner2020;

import java.util.LinkedList;
import java.util.Queue;

public class s3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 s = new Solution3();
		int[] a = s.solution(73425);
		for (int i = 0; i < 2; i++) {
			System.out.print(a[i]+" ");
		}
	}

}
class Solution3 {
	class sol{
		int ans,cnt;
		public sol(int ans, int cnt) {
			this.ans = ans;
			this.cnt = cnt;
		}
	}
    public int[] solution(int n) {
    	Queue<sol> q = new LinkedList<sol>();
    	q.add(new sol(n, 0));
    	while(!q.isEmpty()) {
    		sol temp = q.poll();
    		System.out.println(temp.ans+" "+temp.cnt);
    		if(temp.ans<10) {
    			int[] answer = {temp.cnt,temp.ans};
    			return answer;
    		}
    		int a=10;
    		int t=1;
    		do {
    			if(String.format("%0"+t+"d", temp.ans%a).charAt(0)=='0') {
    				a*=10;
        			t++;
    				continue;
    			}
    			int b=temp.ans/a;
    			int c=temp.ans%a;
//    			System.out.println(temp.ans+" "+temp.cnt);
//    			System.out.println(a+" "+b+" "+c+" "+String.format("%0"+t+"d", temp.ans%a)+" "+t);
//    			System.out.println();
    			a*=10;
    			t++;
    			q.add(new sol(b+c, temp.cnt+1));
    		}while((temp.ans/a)>0);
    	}
        return null;
    }
}