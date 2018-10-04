package Pieces;

public class Knight extends ChessPieces{
	


	
	public Knight(int initialRow, int initialCol, String color) {
		super(initialRow, initialCol, color);
		// TODO Auto-generated constructor stub
	}

	public boolean KnightcanMoveTo(int destinationRow, int destinationCol){
	int diffRow = Math.abs(destinationRow - this.initialRow);
	int diffCol= Math.abs(destinationCol - this.initialCol);
		if(( diffRow == 1  && diffCol == 2) || (diffRow == 2 && diffCol == 1)){
			return true;
		}else 
			return false;
	
	}
	
	// check if there is a piece in the destination row
	// get piece type
}