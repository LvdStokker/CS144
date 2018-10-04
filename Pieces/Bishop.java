package Pieces;

public class Bishop extends ChessPieces{


	public Bishop(int initialRow, int initialCol, String color) {
		super(initialRow, initialCol, color);
		// TODO Auto-generated constructor stub
	
	}

	public boolean BishopCanMoveTo(int destinationRow,int destinationCol ){
		int diffRow = Math.abs(destinationRow - initialRow);
		int diffCol = Math.abs(destinationCol - initialCol);
		if(diffRow == diffCol)
			return true;
		else 
			return false;
		
	}
}
