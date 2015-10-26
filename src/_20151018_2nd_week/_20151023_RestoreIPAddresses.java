package _20151018_2nd_week;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _20151023_RestoreIPAddresses {
	/**I didn't figure it out myself.*/
//	public List<String> restoreIpAddresses(String s){
//		if(s.length() < 4 || s.length() > 12){
//			return Collections.<String>emptyList();
//		}
//	}
	
	/**Then I copied the following solution from discuss, which uses backtracking.*/
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s,"",res,0);
        return res;
    }
    public void helper(String s, String tmp, List<String> res,int n){
        if(n==4){
            if(s.length()==0) res.add(tmp.substring(0,tmp.length()-1));
            //substring here to get rid of last '.'
            return;
        }
        for(int k=1;k<=3;k++){
            if(s.length()<k) continue;
            int val = Integer.parseInt(s.substring(0,k));
            if(val>255 || k!=String.valueOf(val).length()) continue;
            /*in the case 010 the parseInt will return len=2 where val=10, but k=3, skip this.*/
            helper(s.substring(k),tmp+s.substring(0,k)+".",res,n+1);
        }
    }
    
    public static void main(String... args){
    	_20151023_RestoreIPAddresses test = new _20151023_RestoreIPAddresses();
    	System.out.println(test.restoreIpAddresses("123456789"));
    	System.out.println(test.restoreIpAddresses("123321223123"));
    }
}
