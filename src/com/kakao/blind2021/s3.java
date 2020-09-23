package com.kakao.blind2021;

public class s3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Solution {
    public int[] solution(String[] info, String[] query) {
    	int[] answer = new int[query.length];
    	for (int i = 0; i < query.length; i++) {
    		String[] s=query[i].split(" ");
			String language=s[0];
			String dept=s[2];
			String career=s[4];
			String food=s[6];
			int point=Integer.parseInt(s[7]);
			int ans=0;
			for (int j = 0; j < info.length; j++) {
               String[] s2=info[j].split(" ");
               boolean b = false;
				if((s2[0].equals(language) || language.equals("-")) && (s2[1].equals(dept) || dept.equals("-"))
					&& (s2[2].equals(career) || career.equals("-")) && (s2[3].equals(food) || food.equals("-")) && Integer.parseInt(s2[4])>=point)
					b= true;
				else
					b= false;
				if(b)
					ans++;
			}
			answer[i]=ans;
		}
        return answer;
    }
}