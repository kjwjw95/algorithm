package com.programmers.kakao;
import java.util.*;

public class 자물쇠와열쇠 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	class Loc{
	    int row,col;
	    public Loc(int r, int c){
	        this.row=r;
	        this.col=c;
	    }
	}

	class Solution {
	    public boolean solution(int[][] key, int[][] lock) {
	        boolean first=false;
	        int M=key.length;
	        int N=lock.length;
	        ArrayList<Loc> keys = new ArrayList<Loc>();
	        ArrayList<Loc> locks = new ArrayList<Loc>();
	        locks=Find(lock,0);
	        int holesize=locks.size();
	        if(holesize==0) return true;
	        for(int i=0;i<4;i++){
	            keys=Find(key,1);
	            for(Loc l : locks){
	                
	                
	                for(int j=0;j<keys.size()-1;j++){
	                    int cnt=1;
	                    boolean islock=true;
	                    for(int k=j+1;k<keys.size();k++){
	                        int dr=keys.get(k).row-keys.get(j).row;
	                        int dc=keys.get(k).col-keys.get(j).col;
	                        int nr=l.row+dr;
	                        int nc=l.col+dc;
	                        
	                        if(nr<0 || nr>=N || nc<0 || nc>=N)
	                            continue;
	                        if(lock[nr][nc]==0){
	                            cnt++;
	                         }else if(lock[nr][nc]==1){
	                            islock = false;
	                             break;
	                        }
	                    }
	                    if(cnt==holesize && islock)
	                                return true;
	                }
	            }
	            if(i<3)
	                key=Rotate(key);
	        }
	        return false;
	    }
	    public ArrayList<Loc> Find(int[][] key,int n){
	        ArrayList<Loc> keys = new ArrayList<Loc>();
	        int M=key.length;
	        boolean first=false;
	        for(int j=0;j<M; j++){
	                for(int k=0;k<M;k++){
	                    if(key[j][k]==n)
	                            keys.add(new Loc(j,k));

	                }
	            }
	        return keys;
	    }
	   public int[][] Rotate(int[][] key){
	        int length=key.length;
	        int[][] temp = new int[length][length];
	        for(int i=0;i<length;i++){
	            for(int j=0;j<length;j++){
	               temp[i][length-j-1]= key[j][i];
	            }
	        }
	        return temp;
	    }
	}

}
