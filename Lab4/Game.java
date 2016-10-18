import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Game  {


		public final static char Board[] = {'1','2','3','4','5','6','7','8','9'};
		public static final int BOARD_SIZE = 9;
		
		public static final char HUMAN_PLAYER = 'X';
		public static final char COMPUTER_PLAYER = 'O';
		
		public static int steps = 0; 
	
		
		
		public int checkForWinner() {
			
			// Check horizontal wins
			for (int i = 0; i <= 6; i += 3)	{
				if (Board[i] == HUMAN_PLAYER && 
					Board[i+1] == HUMAN_PLAYER &&
					Board[i+2]== HUMAN_PLAYER)
					return 2;
				if (Board[i] == COMPUTER_PLAYER && 
					Board[i+1]== COMPUTER_PLAYER && 
					Board[i+2] == COMPUTER_PLAYER)
					return 3;
			}
		
			// Check vertical wins
			for (int i = 0; i <= 2; i++) {
				if (Board[i] == HUMAN_PLAYER && 
					Board[i+3] == HUMAN_PLAYER && 
					Board[i+6]== HUMAN_PLAYER)
					return 2;
				if (Board[i] == COMPUTER_PLAYER && 
					Board[i+3] == COMPUTER_PLAYER && 
					Board[i+6]== COMPUTER_PLAYER)
					return 3;
			}
		
			// Check for diagonal wins
			if ((Board[0] == HUMAN_PLAYER &&
				 Board[4] == HUMAN_PLAYER && 
				 Board[8] == HUMAN_PLAYER) ||
				(Board[2] == HUMAN_PLAYER && 
				 Board[4] == HUMAN_PLAYER &&
				 Board[6] == HUMAN_PLAYER))
				return 2;
			if ((Board[0] == COMPUTER_PLAYER &&
				 Board[4] == COMPUTER_PLAYER && 
				 Board[8] == COMPUTER_PLAYER) ||
				(Board[2] == COMPUTER_PLAYER && 
				 Board[4] == COMPUTER_PLAYER &&
				 Board[6] == COMPUTER_PLAYER))
				return 3;
		
			// Check for tie
			for (int i = 0; i < BOARD_SIZE; i++) {
				// If we find a number, then no one has won yet
				if (Board[i] != HUMAN_PLAYER && Board[i] != COMPUTER_PLAYER)
					return 0;
			}
		
			// If we make it through the previous loop, all places are taken, so it's a tie
			return 1;
		}
		
	
		
		
	
		
		
		
		
		public static void main(String[] args){
			
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss K:m:s a (dd/MM/yyyy) \n"); 
			String a =dateFormat.format( new Date() );
				long start = System.currentTimeMillis();
			
			
			
			
			Board b = new Board();
			Player user = new Player();
			Player comp = new Player();
			Game check = new Game();
			
			
			
					
			char turn = HUMAN_PLAYER;    // Human starts first
			int  win = 0;                // Set to 1, 2, or 3 when game is over
			
			
			// Keep looping until someone wins or a tie
			while (win == 0)
			{	
				b.displayBoard();

				if (turn == HUMAN_PLAYER)
				{
					user.getUserMove();
					turn = COMPUTER_PLAYER;
				}
				else
				{
					comp.getComputerMove();
					turn = HUMAN_PLAYER;
				}	

				win = check.checkForWinner();
			}

			b.displayBoard();

			// Report the winner
			
			System.out.println();
			if (win == 1) {
				System.out.println("It's a tie.");
			}
			else if (win == 2){
				System.out.println("Player wins!"); 
			}
			else if (win == 3){
				System.out.println("Computer wins!");
			}
			else
				System.out.println("There is a logic problem!");
			
			
			
			
			
			
			   long finish = System.currentTimeMillis();
			   long timeConsumedMillis = finish - start;
		
			 SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss K:m:s a (dd/MM/yyyy) \n"); 
	
			
			
			
			
					
			
			try(FileWriter writer = new FileWriter("D:\\results.txt", false))
		     {
		        
		         String ties = "Game result: Tie ";
		         String winss = "Game result: Player wins ";
		         String loses = "Game result: Computer wins ";
		         
		         String time = "Game time: "+timeConsumedMillis/1000+" seconds";
		         String startgame = "Game start: " + a;
		         String gameover = "Game over: " + dateFormat2.format( new Date() ) ;
		         
		         String st = "Steps were done: "+steps;
		         
		         
		         if (win == 1) {
		        	 writer.write(ties+"\r\n");
					}
					else if (win == 2){
						writer.write(winss+"\r\n");
					}
					else if (win == 3){
						 writer.write(loses+"\r\n");
					}
		         
		         
		         writer.write(time+"\r\n");
		         writer.write(startgame+"\r\n");
		         writer.write(gameover+"\r\n");
		         
		         writer.write(st+"\r\n");
		         
		     }
		     catch(IOException ex){
		          
		         System.out.println(ex.getMessage());
		     } 
			
				
			
		}	
	
		
}	
		
		
