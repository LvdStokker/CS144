package Pieces;
/*

 * This class represents the Queen type of chess piece. This piece can move and capture
 * in any straight line (diagonally, horizontally, or vertically). 
 */

public class Queen extends ChessPieces{

	public Queen(int initialRow, int initialCol, String color) {
		super(initialRow, initialCol, color);
		// TODO Auto-generated constructor stub
	}

	public boolean QueencanMoveTo(int destinationRow, int  destinationCol){
		int diffRow = Math.abs(destinationRow - initialRow);
		int diffCol = Math.abs(destinationCol - initialCol);
		
		if((diffRow == 0 && diffCol == 0) || (initialRow == destinationRow) ||(initialCol == destinationCol)){
			return true;
		}
		else
			return false;
	}

}
// eventully get type