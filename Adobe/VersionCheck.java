package Adobe;

import java.util.Scanner;

public class VersionCheck {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(compare(s1,s2));
		
	}
	public static String compare(String s1,String s2) {
		int n = s1.length();
		int m = s2.length();
		int i = 0,j=0,I=0,J=0;
		while(i<n && j<m) {
			while(I<n && s1.charAt(I)!='.') {
				I++;
			}
			while(J<m && s2.charAt(J)!='.') {
				J++;
			}
			String sub1 = s1.substring(i,I);
			String sub2 = s2.substring(j,J);
			int num1 = Integer.parseInt(sub1);
			int num2 = Integer.parseInt(sub2);
			I++;
			J++;
			i=I;
			j=J;
			if(num1==num2) {
				continue;
			}else if(num1>num2){
				return s1;
			}else{
				return s2;
			}			
		}
		if(i<n) {
			return s1;
		}else if(j<m){
			return s2;
		}else {
			return "Equal";
		}
	}
}
