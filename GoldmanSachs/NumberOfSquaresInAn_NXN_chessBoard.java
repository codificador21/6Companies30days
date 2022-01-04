package GoldmanSachs;

public class NumberOfSquaresInAn_NXN_chessBoard {
	public static void main(String[] args) {
		int n = 8; //
		System.out.println(countsquares(n)); 
	}
	public static int countsquares(int n) {
		return (n*(2*n+1)*(n+1))/6; // for n = 8; 1 x 1,2 x 2, 3 x 3, 4 x 4, 5 x 5, 6 x 6, 7 x 7,8 x 8
	}

}
