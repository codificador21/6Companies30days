// { Driver Code Starts
import java.util.*;
import java.lang.Math;
class Pots{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int[] a =new  int[n];
			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
			}
			GfG g = new GfG();
			System.out.println(g.maxCoins(a,n));
			
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public static int maxCoins(int arr[],int n)
	{
          //add code here.
          int[][]dp = new int[n][n];
          for(int g = 0;g<n;g++){
              for(int i=0,j=g;j<n;i++,j++){
                  if(g==0){
                      dp[i][j] = arr[i];
                  }else if(g==1){
                      dp[i][j] = Math.max(arr[i],arr[j]);
                  }else{
                      int val1 = arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]);
                      int val2 = arr[j] + Math.min(dp[i][j-2],dp[i+1][j-1]);
                      dp[i][j] = Math.max(val1,val2);
                  }
              }
          }
          return dp[0][n-1];
    }
}
/*Two players X and Y are playing a game in which there are pots of gold arranged in a line, each containing some gold coins. They get alternating turns in which the player can pick a pot from one of the ends of the line. The winner is the player who has a higher number of coins at the end. The objective is to maximize the number of coins collected by X, assuming Y also plays optimally.

Return the maximum coins X could get while playing the game. Initially, X starts the game.


Example 1:

Input:
N = 4
Q[] = {8, 15, 3, 7}
Output: 22
Explanation: Player X starts and picks 7. Player Y 
picks the pot containing 8. Player X picks the pot
containing 15. Player Y picks 3.
Total coins collected by X = 7 + 15 = 22.
Example 2:

Input:
N = 4
A[] = {2, 2, 2, 2}
Output: 4 */