
	import java.util.Random;

	
public class Game  {


		public char Board[] = {'1','2','3','4','5','6','7','8','9'};
		public final int BOARD_SIZE = 9;
		
		public static final char HUMAN_PLAYER = 'X';
		public static final char COMPUTER_PLAYER = 'O';
		
		public static Random Rand; 
		
		
		
		
		
		public static void main(String[] args) {
		
			Player a = new Player();
			Board b = new Board();	
			
			Rand = new Random(); 
					
			char turn = HUMAN_PLAYER;    // Human starts first
			int  win = 0;                // Set to 1, 2, or 3 when game is over
			
			
			// Keep looping until someone wins or a tie
			while (win == 0)
			{	
				b.displayBoard();

				if (turn == HUMAN_PLAYER)
				{
					a.getUserMove();
					turn = COMPUTER_PLAYER;
				}
				else
				{
					a.getComputerMove();
					turn = HUMAN_PLAYER;
				}	

				win = a.checkForWinner();
			}

			b.displayBoard();

			// Report the winner
			System.out.println();
			if (win == 1) 
				System.out.println("It's a tie.");
			else if (win == 2)
				System.out.println("Player wins!");
			else if (win == 3)
				System.out.println("Computer wins!");
			else
				System.out.println("There is a logic problem!");
		
		
	
		}	
	
}
