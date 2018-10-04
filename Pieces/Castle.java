package Pieces;

public class Castle extends ChessPieces {

	public Castle(int initialRow, int initialCol, String color) {
		super(initialRow, initialCol, color);
		// TODO Auto-generated constructor stub
	}
	
	public boolean canMoveTo(int destinationRow, int destinationCol){
		if((destinationRow == initialRow ) || (initialCol == destinationCol))
			return true;
		else 
			return false;
	}

}
