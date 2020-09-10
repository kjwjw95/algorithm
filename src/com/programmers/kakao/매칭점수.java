package com.programmers.kakao;

import java.util.ArrayList;

public class 매칭점수 {

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		String w1="blind";
		String[] s1 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		System.out.println(s.solution(w1, s1));
	}
}

class Solution4 {
	public class Web{
		float basicPoint,LinkPoint,link;
		String adress;
		ArrayList<String> externalAdress = new ArrayList<String>();
	}
    public int solution(String word, String[] pages) {
        int answer = 0;
        float maxPoint=0;
        int N=pages.length;
        Web[] webs = new Web[N];
        for (int i = 0; i < webs.length; i++) {
			webs[i]=Parsing(pages[i],word);
		}
        for (int i = 0; i < webs.length; i++) {
        	float point=CaculPoint(i,webs);
			if(point>maxPoint) {
				answer=i;
				maxPoint=point;
			}
		}
        return answer;
    }
	private float CaculPoint(int i, Web[] webs) {
		float point=webs[i].basicPoint;
		String url = webs[i].adress;
		for (int j = 0; j < webs.length; j++) {
			if(j==i)	continue;
			for(String s : webs[j].externalAdress) {
				if(s.equals(url)) {
					point+=webs[j].basicPoint/webs[j].link;

				}
			}
		}
		return point;
	}
	private Web Parsing(String page, String word) {
		Web web = new Web();
		word=word.toLowerCase();
		web.adress=Findurl("<meta property=\"og:url\" content=",page);
		
		String[] temp=page.split("<body>");
		temp=temp[1].split("</body>");
		String body=temp[0].toLowerCase();
		String findExternal="<a href=";
		while(body.contains(findExternal)){
			String externel = Findurl(findExternal, body);
			web.externalAdress.add(externel);
			body=body.replaceFirst(findExternal, "");
			body=body.replaceFirst('"'+externel+'"'+'>', ""); 
		}
		while(body.contains(word)) {
			char nextnum=body.charAt(body.indexOf(word)+word.length());
			if(nextnum>=97 && nextnum<=122) {
				body=body.replaceFirst(word+nextnum, "");
			}else {
				body=body.replaceFirst(word, "");
				web.basicPoint++;
			}
		}
		web.link=web.externalAdress.size();
		return web;
	}
	private String Findurl(String findurl, String page) {
		String[] temp = page.split(findurl);
		String url="";
		for (int i = 1; i < temp[1].length(); i++) {
			if(temp[1].charAt(i)=='"') break;
			url+=temp[1].charAt(i);
		}
		return url;
	}
}