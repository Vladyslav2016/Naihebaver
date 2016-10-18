import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Player extends Game {
	 

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
		steps++;
	
	}
	
	
	public void getComputerMove() 
	{   
		Random Rand = new Random(); 
		int move;

		// First see if there's a move O can make to win
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (Board[i] != HUMAN_PLAYER && Board[i] != COMPUTER_PLAYER) {
				char curr = Board[i];
				Board[i] = COMPUTER_PLAYER;
				if (checkForWinner() == 3) {
					System.out.println("Computer is moving to " + (i + 1));
					steps++;
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
					steps++;
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
		steps++;
	}	
	
	
	
	
}
