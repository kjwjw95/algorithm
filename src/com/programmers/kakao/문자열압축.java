package com.programmers.kakao;
import java.lang.Math;
public class 문자열압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int solution(String s) {
	        int size=s.length();
	        int answer = size;  //최댓값은 string의 길이
	        String[] alphabet;
	        int cnt=1;
	        int ans;
	        int N;
	        boolean isrepeat=false;
	        for(int i=1;i<=size/2;i++){  //나뉘는 숫자
	            N=size/i;       //N은 몇개의 문자열로 나뉘어지는가
	            ans=0;
	            isrepeat=false;
	            if(size%i!=0)   //자르고 남은 것을 붙여줌
	                N++;
	            alphabet = new String[N];   //알파벳 배열
	            for(int j=0, k=0; k<N; j+=i,k++){   //i개 단위로 잘라서 배열에 저장
	                alphabet[k]= (j+i<=size) ? s.substring(k*i,i*(k+1)) : s.substring(j);
	            }
	            for(int j=0;j<N-1;j++){     
	                if(ans>=answer)     break;  //만약 임시 ans값이 answer보다 크거나 같다면 더는 의미 없으므로 break
	                String s1= alphabet[j];
	                String s2= alphabet[j+1];
	                
	                if(s1.equals(s2)){  //만약 연속된 문자가 같으면
	                    isrepeat=true;
	                    cnt++;          //cnt가 증가, isrepeat가 트루
	                }else{
	                    if(isrepeat){   //앞에서 문자가 같은 적이 있는데 다른 문자가 나왔다면
	                        ans+=(cnt+"").length()+i;
	                        cnt=1;
	                        isrepeat=false;
	                    }else{
	                        ans+=i;
	                    }
	                }
	                if(j==N-2){
	                    if(isrepeat){
	                        ans+=(cnt+"").length()+i;
	                        cnt=1;
	                       // System.out.println(dec+" "+i);
	                        isrepeat=false;
	                    }else{
	                        ans+=s2.length();
	                    }
	                }
	                
	            }
	            answer=Math.min(answer,ans);
	        }
	        return answer;
	    }
	}
}
