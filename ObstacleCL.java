//This will run the command line interface
public class ObstacleCL {

	public static void main(String[] args) 
	{
		String boardFile = args[0];
		String gameFile = args[1];
		
		Board board = new Board();
		
		board.readBoardFile(boardFile);
		board.showClBoard();
	}
}
