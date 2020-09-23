package com.kakao.blind2021;

public class s1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.solution("...!@BaT#*..y.abcdefghijklm."));
		System.out.println(s.solution("z-+.^."));
		System.out.println(s.solution("=.="));
		System.out.println(s.solution("123_.def"));
		System.out.println(s.solution("abcdefghijklmn.p"));
	}

}
class Solution1 {
    public String solution(String new_id) {
        String answer = "";
        new_id=Tolower(new_id);
        System.out.println("소문자 변환 : "+new_id);
        new_id=DeleteChar(new_id);
        System.out.println("특문제거 : "+new_id);
        new_id=DoblueDot(new_id);
        System.out.println("연속 점 : "+new_id);
        new_id=CheckDot(new_id);
        System.out.println("점 체크: "+new_id);
        new_id=IsItBlank(new_id);
        System.out.println("빈 문자인지 : "+new_id);
        new_id=IsTooLong(new_id);
        System.out.println("길면 짜르기: "+new_id);
        answer=IsTooShort(new_id);
        System.out.println("짧으면 늘리기 : "+new_id);
        return answer;
    }

	private String CheckDot(String new_id) {
		// TODO Auto-generated method stub
		if(new_id.length()==0)	return new_id;
		if(new_id.charAt(0)=='.')
			new_id=new_id.substring(1);
		if(new_id.length()==0)	return new_id;
		if(new_id.charAt(new_id.length()-1)=='.')
			new_id=new_id.substring(0,new_id.length()-1);
		
		return new_id;
	}

	private String IsTooShort(String new_id) {
		if(new_id.length()>2)
			return new_id;
		char c = new_id.charAt(new_id.length()-1);
		for (int i = new_id.length(); i < 3; i++) {
			new_id+=c;
		}
		return new_id;
	}

	private String IsTooLong(String new_id) {
		if(new_id.length()<15)
			return new_id;
		new_id=new_id.substring(0, 15);
		new_id=CheckDot(new_id);
		return new_id;
	}

	private String IsItBlank(String new_id) {
		if(new_id.length()==0)
			return "a";
		else
		return new_id;
	}

	private String DoblueDot(String new_id) {
		String ans="";
		for (int i = 0; i < new_id.length()-1; i++) {
			char c = new_id.charAt(i);
			char c2 = new_id.charAt(i+1);
			if(c=='.' && c2=='.')
				continue;
			ans+=c;
		}
		ans+=new_id.charAt(new_id.length()-1);
		return ans;
	}

	private String DeleteChar(String new_id) {
		String ans="";
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if(c=='.' || c=='_' || c=='-' ||(c>=48 && c<=57) ||(c>=97 && c<=122))
				ans+=c;
		}
		return ans;
	}

	private String Tolower(String new_id) {
		new_id=new_id.toLowerCase();
		return new_id;
	}
}