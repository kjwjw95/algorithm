package com.programmers.kakao;

import java.util.Arrays;
import java.util.Comparator;

public class 실패율 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution5 {
	class Stage{
		int num, sucess;
		float ratio;
        @Override
		public String toString() {
			return "Stage [num=" + num + ", sucess=" + sucess + ", ratio=" + ratio + "]";
		}
	}
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int user=stages.length;
        Stage[] stage = new Stage[N];
        
        for (int i = 0; i < N; i++) {
			stage[i] = new Stage();
			stage[i].num=i+1;
		}
        
        for (int i = 0; i < stages.length; i++) {
			int userstop=stages[i];
			for (int j = 0; j < userstop-1; j++) {
				stage[j].sucess++;
			}
		}
 
        for (int i = 0; i < N; i++) {
        	int n=user-stage[i].sucess;
			stage[i].ratio=(float)n/(float)user;
            System.out.println(stage[i]+" "+n+" "+user);
			user-=n;
            
		}
        
        
        Arrays.sort(stage,new Comparator<Stage>() {

			@Override
			public int compare(Stage o1, Stage o2) {
				if(o1.ratio>o2.ratio)	return -1;
				else if(o1.ratio<o2.ratio)	return 1;
				else
				return o1.num-o2.num;
			}
        	
        });
        for (int i = 0; i < N; i++) {
			answer[i]=stage[i].num;
		}
        return answer;
    }
}