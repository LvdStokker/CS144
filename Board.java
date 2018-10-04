import stdlib.StdDraw;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Board 
{
	private final static int boardSize = 8;
	private final static int walls = 2;
	private final static int space = 1;
	
	private static char[][] chessBoard = new char[boardSize][0];//Jagged Array
	private char[] header = {' ','a','b','c','d','e','f','g','h'};
	private char[] side = {'8','7','6','5','4','3','2','1'};
	
	private String[] whitePieces = {"Images\\WCastle.png", "Images\\WKnight.png", 
									"Images\\WBishop.png", "Images\\WQueen.png",
									"Images\\WKing.png", "Images\\WPawn.png"};
	private String[] blackPieces = {"Images\\BCastle.png", "Images\\BKnight.png", 
									"Images\\BBishop.png", "Images\\BQueen.png",
									"Images\\BKing.png", "Images\\BPawn.png"};
	
	public static String[] boardStatus = new String[6];
	
	public void drawInitialGameBoard()
	{
		//Load Chessboard first
		//defaultBoardSetup();//To be changed based on user input I.e. blank board or from file
		readFromBoardFile();
		drawBlankBoard();
		addPiecesToBoard();
		
		//showClBoard();
	}
	
	public void drawBlankBoard()
	{
		//Draws the checkered board with no pieces
		StdDraw.clear();
		StdDraw.setCanvasSize(GameState.getCanvasSize(), GameState.getCanvasSize());
		StdDraw.setXscale(0, getBoardsize()+2);
		StdDraw.setYscale(0, getBoardsize()+2);

		for (int i = 0; i < boardSize+2; i++) 
		{
			for (int j = 0; j < boardSize+2; j++) 
			{
				if(i == 0 || i == boardSize+1)
				{
					//Put Numbers
					if (j >= 1 && j <= boardSize)
					{
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.text(i+0.5, j+0.5, Integer.toString(j));
					}
				}
				if(j == 0 || j == boardSize+1)
				{
					//Put Letters
					if (i >= 1 && i <= boardSize)
					{
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.text(i+0.5, j+0.5, Character.toString((char)(i+96)));
					}
				}
				if((i > 0 && i < boardSize+1) && (j > 0 && j < boardSize+1))
					
				{
					if (((i + j)-2) % 2 == 0)
						StdDraw.setPenColor(StdDraw.GRAY);
				
					else
						StdDraw.setPenColor(StdDraw.WHITE);
					//Draw a square of "radius" 0.5 at a center point of the square location
					StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
				}
				
			}
		}
		// Draw  a border around the board
		for (int row = 0; row < boardSize+2; row++) {
			for (int cols = 0; cols < boardSize; cols++){
				if (row == 1 && cols == 1){ 
					StdDraw.setPenRadius(0.0035);
					StdDraw.line(1.0, 1.0, 9.0, 1.0);
					StdDraw.line(1.0, 1.0, 1.0, 9.0);
				}
				if (row == 9 && cols == 1) {
					StdDraw.line(1.0, 9.0, 9.0, 9.0);
					StdDraw.line(9.0, 9.0, 9.0, 1.0);
				}
			}		
		}
	}
	
	public void addPiecesToBoard()
	{
		int piecePos;
		StdDraw.setPenRadius(0.01);
		// Draw images of chess pieces onto board in reverse row order of the array
		for (int row = boardSize-1; row >= 0; row--){
			piecePos = 0;
			for(int col  = 0; col < chessBoard[row].length; col ++){
				if(chessBoard[row][col] == '|' || chessBoard[row][col] == '_')
				{
					piecePos+=1;
				}
				switch(chessBoard[row][col])
				{
				case 'R': //White Castle
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, whitePieces[0], 1, 1);
					break;
				case 'N': //White Knight
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, whitePieces[1], 1, 1);
					break;
				case 'B': //White Bishop
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, whitePieces[2], 1, 1);
					break;
				case 'Q': //White Queen
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, whitePieces[3], 1, 1);
					break;
				case 'K': //White King
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, whitePieces[4], 1, 1);
					break;
				case 'P': //White Pawn
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, whitePieces[5], 1, 1);
					break;
				case 'r': //Black Castle
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, blackPieces[0], 1, 1);
					break;
				case 'n': //Black Knight
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, blackPieces[1], 1, 1);
					break;
				case 'b': //Black Bishop
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, blackPieces[2], 1, 1);
					break;
				case 'q': //Black Queen
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, blackPieces[3], 1, 1);
					break;
				case 'k': //Black King
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, blackPieces[4], 1, 1);
					break;
				case 'p': //Black Pawn
					StdDraw.picture((col - piecePos)+1.5, (boardSize-1-row)+1.5, blackPieces[5], 1, 1);
					break;
				case '|'://West Wall
					StdDraw.picture((col - piecePos)+2, (boardSize-1-row)+1.5, "Images\\WestWall.jpg", 0.25, 1);
					break;
				case '_'://South Wall
					StdDraw.picture((col - piecePos)+2.5, (boardSize-1-row)+1, "Images\\SouthWall.jpg", 1, 0.25);
					break;
				}
			}
		}
	}
	
	public static void defaultBoardSetup()
	{	
		char columns[] = new char[boardSize];
		
		for (int row = 0; row <= boardSize; row++) {
			if(row > 0)
			{
				for(int i = 0; i < columns.length; i++)	{
					chessBoard[row-1][i] = columns[i];
				}
			}
			if(row < boardSize)
			{
				for (int col = 0; col < boardSize; col++) {
					columns[col] = defaultBoard(row, col);
				}
				chessBoard[row] = new char[columns.length];
			}
		}
	}
	
	public static char defaultBoard(int row, int column)
	{
		switch(row)
		{
		case 0:
			if(column == 0 || column == 7)
			{
				return 'R';
			}
			else if(column == 1 || column == 6)
			{
				return 'N';
			}
			else if(column == 2 || column == 5)
			{
				return 'B';
			}
			else if(column == 3)
			{
				return 'Q';
			}
			else
			{
				return 'K';
			}
		case 1:
			return 'P';
		case 6:
			return 'p';
		case 7:
			if(column == 0 || column == 7)
			{
				return 'r';
			}
			else if(column == 1 || column == 6)
			{
				return 'n';
			}
			else if(column == 2 || column == 5)
			{
				return 'b';
			}
			else if(column == 3)
			{
				return 'q';
			}
			else
			{
				return 'k';
			}
			default: 
				return '.';
		}
	}
	
	public void showClBoard()
	{
		Mine mine = new Mine();
		TrapDoor td = new TrapDoor();
		
		
		
		//Print headers
		for (int col = 0; col < header.length; col++) {
			System.out.print(header[col]+" ");
		}
		System.out.print("\n");

		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < chessBoard[row].length+space; col++) {
				if(col == 0)
				{
					System.out.print(side[row]);
				}
				else if(col > 0)
				{
					if(chessBoard[row][col-1] == mine.mineSymbol)
					{
						System.out.print(".");
					}
					else if(chessBoard[row][col-1] == td.hiddenTdSymbol)
					{
						System.out.print(".");
					}
					else
					{
						System.out.print(chessBoard[row][col-1]);
					}
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public void readBoardFile(String boardFile)
	{
		String line = "";
		FileReader in = null;
		int lineLength = 0, nonComment = 0, row = 0;
		
		try {
			in = new FileReader(boardFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(in != null)
		{
			BufferedReader bf = new BufferedReader(in);
			
			try {
				line = bf.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			
			while (line != null)
			{
				if(line.charAt(0) != '%')//It is not a comment
				{
					lineLength = line.length();
					nonComment++;
					if(nonComment < 9)//There are exactly 9 non-comment lines
					{
						chessBoard[row] = new char[lineLength];
						for(int i = 0; i < lineLength; i++)
						{
							chessBoard[row][i] = line.charAt(i);
						}
						row++;
					}
					else
					{
						//TODO Read board status
						boardStatus = line.split(" ");
					}
				}
				else
				{
					//Do something with the comment?
				}
				//Read next line
				try {
					line = bf.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	//Change Name
	public void readFromBoardFile()
	{
		String line = "";
		String filename = "";
		int nonComment = 0, lineLength = 0;
		int row = 0;
		int wallCounter = 0;
		int i = 0;
		
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Board Files", "board");
		chooser.setFileFilter(filter);
		int retval = JFileChooser.CANCEL_OPTION;
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		retval = chooser.showDialog(null, "Select");
		
		if(retval == JFileChooser.CANCEL_OPTION)
		{
			System.out.println("User Cancelled.");
		}
		else if(retval == JFileChooser.APPROVE_OPTION)
		{
			filename = chooser.getSelectedFile().getAbsolutePath();
			if(!filename.contains(".board"))
			{
				System.out.println("Invalid file type chosen.");
			}
			else
			{
				FileReader in = null;
				try {
					in = new FileReader(filename);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
				if(in != null)
				{
					BufferedReader bf = new BufferedReader(in);
					
					try {
						line = bf.readLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
					
					while (line != null)
					{
						if(line.charAt(0) == '%')
						{
							//It is a comment
						}
						else
						{
							lineLength = line.length();
							nonComment++;
							if(nonComment < 9)
							{
								chessBoard[row] = new char[lineLength];
								for(i = 0; i < lineLength; i++)
								{
									chessBoard[row][i] = line.charAt(i);
								}
								row++;
							}
							else
							{
								//Read board status
							}
						}
						//Read next line
						try {
							line = bf.readLine();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
					}
				}
				
			}
		}
	}

	public static int getBoardsize() {
		return boardSize;
	}

	
}
