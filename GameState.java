import stdlib.*;

import java.awt.Font;
import java.util.Scanner;
//Contains the methods and functions which control the current state of our game

public class GameState 
{	
	private final static int canvasSize = 600;
	private static Board board = new Board();
	private static int initScale = Board.getBoardsize()+2;
	private static double qsX = (double)initScale*0.25;
	private static double qsY = (double)initScale*0.5;
	private static double csX = (double)initScale*0.75;
	private static double csY = (double)initScale*0.5;
	private static double butWidth = 1.75;
	private static double butHeight = 0.75;
	
	
	public void initialScreen()
	{
		StdDraw.setCanvasSize(canvasSize, canvasSize);
		StdDraw.setXscale(0, initScale);
		StdDraw.setYscale(0, initScale);
		StdDraw.clear(StdDraw.LIGHT_GRAY);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		Font font = new Font("Arial", Font.BOLD, 32);
		StdDraw.setFont(font);
		StdDraw.text(initScale/2, (double)initScale*0.75, "Welcome to Obstacle Chess!");
		
		//Quick Setup Button
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		StdDraw.filledRectangle(qsX, qsY, butWidth, butHeight);
		font = new Font("Arial", Font.BOLD, 20);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(qsX, qsY, "Quick Setup");
		
		//Custom Setup Button
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.filledRectangle(csX, csY, butWidth, butHeight);
		font = new Font("Arial", Font.BOLD, 20);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(csX, csY, "Custom Setup");
		
		setupChoice();
	}
	
	public static void setupChoice()
	{
		boolean selected = false;
		int option = 0;
		while (!selected) {
			if (StdDraw.isMousePressed()) {
				if(StdDraw.mouseX() >= csX-butWidth && StdDraw.mouseX() <= csX+butWidth && StdDraw.mouseY() >= csY-butHeight && StdDraw.mouseY() <= csY+butHeight)
				{
					selected = true;
				}
				else if(StdDraw.mouseX() >= qsX-butWidth && StdDraw.mouseX() <= qsX+butWidth && StdDraw.mouseY() >= qsY-butHeight && StdDraw.mouseY() <= qsY+butHeight)
				{
					selected = true;
					option = 1;
				}
			} 
		}
		if(option == 1)
		{
			board.drawBlankBoard();
			Board.defaultBoardSetup();
			board.addPiecesToBoard();
		}
		else
		{
			board.readFromBoardFile();
		}
	}
	
	/*public void startGame()
	{
		System.out.println("Welcome to obstacle chess!");
		Scanner scan = new Scanner(System.in);
		String mode = "";
		boolean valid = true;
		do
		{
			System.out.println("Enter \'c\' for command line mode or \'g\' for graphical mode.");
			mode = scan.nextLine();
			if (mode.equalsIgnoreCase("c") || mode.equalsIgnoreCase("g")) 
			{
				valid = true;
			} 
			else 
			{
				System.out.println("Invalid Option");
				valid = false;
			} 
		}while (!valid);
		
		if(mode.equalsIgnoreCase("c"))
		{
			System.out.println("Command Line Mode");
			commandLineMode();
		}
		else
		{
			System.out.println("Graphical Mode");
		}
		
		scan.close();
	}*/
	
	public static void commandLineMode()
	{
		Board.defaultBoardSetup();
		board.showClBoard();
	}
	
	public static void interactiveMode()
	{
		
	}
	
	public static int getCanvasSize() {
		return canvasSize;
	}
}
