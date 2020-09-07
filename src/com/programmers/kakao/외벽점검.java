package com.programmers.kakao;

public class 외벽점검 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] weak1 = { 1, 5, 6, 10 };
		int[] weak2 = { 1, 3, 4, 9, 10 };

		int[] dist1 = { 1, 2, 3, 4 };
		int[] dist2 = { 3, 5, 7 };

		System.out.println(s.solution(12, weak1, dist1));
		System.out.println(s.solution(12, weak2, dist2));
	}

}

class Solution2 {
	static int answer=Integer.MAX_VALUE;
	public int solution(int n, int[] weak, int[] dist) {
		boolean[] restaurant = new boolean[n * 2];
		for (int w : weak) {
			restaurant[w] = true;
			restaurant[w+n]=true;
		}
		Combination(restaurant,dist,weak,0,n,new int[dist.length],new boolean[dist.length]);

		if (answer==Integer.MAX_VALUE)
			return -1;
		else
			return answer;
	}

	private void Combination(boolean[] restaurant, int[] dist, int[] weak, int cnt, int n, int[] combi, boolean[] select) {
		if(cnt==dist.length) {
			Inspect(restaurant, combi, weak,n);
			return;
		}
		for (int i = 0; i < dist.length; i++) {
			if(select[i])	continue;
			select[i]=true;
			combi[cnt]=dist[i];
			Combination(restaurant, dist, weak, cnt+1, n, combi, select);
			select[i]=false;
		}
	}

	private void Inspect(boolean[] restaurants, int[] dist, int[] weak, int n) {
		int length= weak.length;
		for (int l = 0; l < length; l++) {
			int ans=0;
			int num=l;
			boolean[] restaurant = restaurants.clone();
			for (int i = 0; i < dist.length; i++) {
				int friend = dist[i];	//해당 취약지점을 점검하는 친구(큰 순서대로)
				int cnt=0;
				for (int j = num; j < 2*length; j++) {	//점검할 곳 cnt 찾기
					if(!restaurant[weak[j%length]]) {		//만약 이미 검사했으면 패스
						continue;
					}
					cnt=weak[j%length];
					break;
				}
				for (int k = cnt; k <= ((cnt + friend < restaurant.length) ? cnt + friend : restaurant.length-1); k++) {	//해당 취약지점부터 친구가 가는 곳까지 점검
					restaurant[k]=false;
					if(k+n<restaurant.length)
						restaurant[k+n]=false;
					if(k-n>=0)
						restaurant[k-n]=false;
				}
				ans++;
				num++;
				if(isFinish(restaurant)) {
					answer=Math.min(answer, ans);
					break;
				}
				if(ans>answer)
					break;
			}
		}
	}

	private boolean isFinish(boolean[] restaurant) {
		for(boolean b : restaurant)
			if(b)
				return false;
		return true;
	}
}