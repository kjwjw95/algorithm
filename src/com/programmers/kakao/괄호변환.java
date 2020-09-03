package com.programmers.kakao;

public class 괄호변환 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("()))((()"));
	}

}
class Solution {
    public String solution(String p) {
        
        return Seprate(p);
    }

	private String Seprate(String p) {
		int length =p.length();
		if(length==0)	return "";
		int open=0, close=0;
		String u="";
		String v="";
		for (int i = 0; i < length; i++) {
			char c=p.charAt(i);
			if(c=='(') {
				open++;
			}else if(c==')') {
				close++;
			}
			u+=c;
			if(open!=0 && open==close) {
				if(i<length)
					v=p.substring(i+1);
				break;
			}
		}
		System.out.println("u : "+u);
		System.out.println("v : "+v);
		if(isRight(u)) {
			System.out.println("isright "+u);
			String a= Seprate(v);
			System.out.println(a);
			return u+a;
		}else {
			String a="(";	//4-1
			a+=Seprate(v);	//4-2
			a+=")";			//4-3
			a+=Reverse(u);	//4-4
			System.out.println("isn't right: "+a);
			return a;
		}
		
	}

	private boolean isRight(String u) {
		boolean[] isright = new boolean[u.length()/2];
		int idx=0;
		for (int i = 0; i < u.length(); i++) {
			if(u.charAt(i)=='(') {
				if(isright[idx])
					isright[++idx]=true;
				else
					isright[idx]=true;
				if(idx==isright.length)	return false;
			}else {
				if(isright[idx])
					isright[idx]=false;
				else {
					if(--idx<0)	return false;
					else	isright[idx]=false;
				}
			}
		}
		return true;
	}

	private String Reverse(String u) {
		String a="";
		for (int i = 1; i < u.length()-1; i++) {
			if(u.charAt(i)=='(') {
				a+=')';
			}else {
				a+='(';
			}
		}
		return a;
	}
}
