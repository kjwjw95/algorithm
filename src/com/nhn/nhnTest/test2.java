package com.nhn.nhnTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static void solution(int numOfOrder, String[] orderArr) {
	    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		//int num=0;
		for (int i = 0; i < numOfOrder; i++) {
			Stack<Character> stack= new Stack<Character>();
			Stack<Character> ans = new Stack<Character>();
			String s="";
			boolean isNum=false;
			for (int j = 0; j < orderArr[i].length(); j++) {
				char c = orderArr[i].charAt(j);
				if(c>=48 && c<=57) {	//숫자면
					stack.add(c);
					isNum=true;
				}
				else if(c==')') {	//괄호가 끝나면
					if(stack.empty())
						break;
					char temp = stack.pop();
					if(temp>=48 && temp<=57)
						ans=bracketnum(temp,ans);
					else
						ans=bracketchar(temp,ans);
				}
				else if(j<orderArr[i].length()-1 && orderArr[i].charAt(j+1)=='(') {	//만약 알파벳이고 다음이 괄호면
					stack.add(c);
				}else {//만약 c가 RGB면
					if(isNum && c=='(')
						isNum=false;
					else if(isNum && c!='(') {
						ans.add('(');
						isNum=false;
						ans.add(c);
						ans=bracketnum(stack.pop(),ans);
					}
					ans.add(c);
				}
			}
			for(Character c: ans)
				System.out.print(c);
			System.out.println();
		}
	  }
	private static Stack<Character> bracketchar(char c, Stack<Character> s) {
		String st="";
		Stack<Character> stack= new Stack<Character>();
		while(true) {
			char t=s.pop();
			if(t=='(') {
				while(!stack.empty()) {
					st+=stack.pop();
					st+=c;
				}
				break;
			}
			stack.add(t);
		}
		for(int j=0;j<st.length();j++)
			s.add(st.charAt(j));
		return s;
	}
	private static Stack<Character> bracketnum(char n, Stack<Character> s) {
		String st="";
		Stack<Character> stack= new Stack<Character>();
		while(true) {
			char c=s.pop();
			if(c=='(') {
				while(!stack.empty())
					st+=stack.pop();
				break;
			}
			stack.add(c);
		}
		int num = (n-48);
		for (int i = 0; i < num; i++) {
			for(int j=0;j<st.length();j++)
				s.add(st.charAt(j));
		}
		return s;
	}
	
}
