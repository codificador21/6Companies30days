// { Driver Code Starts
import java.util.*;
import java.lang.String;
import java.lang.Math;
class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			GfG g=new GfG();
			System.out.println(g.missingNumber(s));
		}
	}
}// } Driver Code Ends



class GfG
{
	  static final int MAX_DIGITS = 6;
 

    static int missingNumber(String str) {
        for (int m = 1; m <= MAX_DIGITS; ++m) {
            int n = getValue(str, 0, m);
            if (n == -1) {
                break;
            }
            int missingNo = -1;
            boolean fail = false;
 
            for (int i = m; i != str.length(); i += 1 + Math.log10(n)) {
                if ((missingNo == -1)
                        && (getValue(str, i, (int) (1 + Math.log10(n + 2))) == n + 2)) {
                    missingNo = n + 1;
                    n += 2;
                }
                else if (getValue(str, i, (int) (1 + Math.log10(n + 1))) == n + 1) {
                    n++;
                } else {
                    fail = true;
                    break;
                }
            }
 
            if (!fail) {
                return missingNo;
            }
        }
        return -1;
    }
        static int getValue(String str, int i, int m) {
        if (i + m > str.length()) {
            return -1;
        }
        int value = 0;
        for (int j = 0; j < m; j++) {
            int c = str.charAt(i + j) - '0';
            if (c < 0 || c > 9) {
                return -1;
            }
            value = value * 10 + c;
        }
        return value;
    }
}
/*Given a string consisting of some numbers, not separated by any separator. The numbers are positive integers and the sequence increases by one at each number except the missing number. The task is to complete the function missingNumber which return's the missing number. The numbers will have no more than six digits. Print -1 if input sequence is not valid.

Note: Its is guaranteed that if the string is valid, then it is sure that atleast one number would be missing from the string.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an string s representing a number.

Output:
For each test case in a new line output will be the missing number. Output will be -1 if the input is invalid.

Constraints:
1<=T<=100
1<=Length of string<=100

Example(To be used only for expected output):
Input:
2
9899100102
1112141519

Output:
101
-1*/