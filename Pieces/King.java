package Pieces;

public class King extends ChessPieces{

	public King(int initialRow, int initialCol, String color) {
		super(initialRow, initialCol, color);
		// TODO Auto-generated constructor stub
	}
	
	public boolean canMoveTo(int destinationRow, int destinationCol){
		int diffRow = Math.abs(destinationRow - initialRow);
		int diffCol = Math.abs(destinationCol - initialCol);
		if(( diffRow == 1 && diffCol == 0) || (diffRow == 0 && diffCol == 1))
			return true;
		else
			return false;
	}
}
