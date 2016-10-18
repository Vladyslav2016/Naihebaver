import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Game {

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
	
	
	public void getUserMove() 
	{
		Scanner s = new Scanner(System.in);
		int move = -1;
		
		while (move == -1) {			
			try {
				System.out.print("Enter your move: ");
			    move = s.nextInt();
			
				while (move < 1 || move > BOARD_SIZE || 
					   Board[move-1] == HUMAN_PLAYER || Board[move-1] == COMPUTER_PLAYER) {
					
					if (move < 1 || move > BOARD_SIZE)
						System.out.println("Please enter a move between 1 and " + BOARD_SIZE + ".");
					else
						System.out.println("That space is occupied.  Please choose another space.");
		
					System.out.print("Enter your move: ");
				    move = s.nextInt();
				}
			} 
			catch (InputMismatchException ex) {
				System.out.println("Please enter a number between 1 and " + BOARD_SIZE + ".");
				s.next();  // Get next line so we start fresh
				move = -1;
			}
		}

		Board[move-1] = HUMAN_PLAYER;
	
	}
	
	
	
	public void getComputerMove() 
	{
		int move;

		// First see if there's a move O can make to win
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (Board[i] != HUMAN_PLAYER && Board[i] != COMPUTER_PLAYER) {
				char curr = Board[i];
				Board[i] = COMPUTER_PLAYER;
				if (checkForWinner() == 3) {
					System.out.println("Computer is moving to " + (i + 1));
					return;
				}
				else
					Board[i] = curr;
			}
		}

		// See if there's a move O can make to block X from winning
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (Board[i] != HUMAN_PLAYER && Board[i] != COMPUTER_PLAYER) {
				char curr = Board[i];   // Save the current number
				Board[i] = HUMAN_PLAYER;
				if (checkForWinner() == 2) {
					Board[i] = COMPUTER_PLAYER;
					System.out.println("Computer is moving to " + (i + 1));
					return;
				}
				else
					Board[i] = curr;
			}
		}

		// Generate random move
		do
		{
			move = Rand.nextInt(BOARD_SIZE);
		} while (Board[move] == HUMAN_PLAYER || Board[move] == COMPUTER_PLAYER);
			
		System.out.println("Computer is moving to " + (move + 1));

		Board[move] = COMPUTER_PLAYER;
	}	
	
	
	
	
}
