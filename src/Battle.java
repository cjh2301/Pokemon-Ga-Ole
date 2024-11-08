import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Pokemon playerPokemon1;
    private Pokemon playerPokemon2;
    private Pokemon wildPokemon1;
    private Pokemon wildPokemon2;
    private boolean healUsed = false;
    private ArrayList<Ball> pokeballs = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

   
    public Battle(Pokemon playerPokemon1, Pokemon playerPokemon2, Pokemon wildPokemon1, Pokemon wildPokemon2) {
		this.playerPokemon1 = playerPokemon1;
		this.playerPokemon2 = playerPokemon2;
		this.wildPokemon1 = wildPokemon1;
		this.wildPokemon2 = wildPokemon2;
	}


	public void startBattle() {
        int enterCount = 0;
        boolean isPlayerTurn = true;

        while ((wildPokemon1.getHp() > 0 || wildPokemon2.getHp() > 0) && (playerPokemon1.getHp() > 0 || playerPokemon2.getHp() > 0)) {
        	
        	 if (!healUsed) {
                 Heal();
             }
        	 
            if (isPlayerTurn) {
                System.out.println("Player: Press enter to attack. Attack by pressing enter 5 times.");

                while (enterCount != 5) {
                    String input = scanner.nextLine();
                    enterCount++;
                }
            }

            if (enterCount >= 5) {
                playerPokemon1.attack(wildPokemon1);
                playerPokemon1.attack(wildPokemon2);
                playerPokemon2.attack(wildPokemon1);
                playerPokemon2.attack(wildPokemon2);
                enterCount = 0; // Reset enter count after attack
                displayHealth();
                isPlayerTurn = false; // Switch to Player 2's turn
            } else {
                System.out.println("Opponent attacks.");
                wildPokemon1.attack(playerPokemon1);
                wildPokemon1.attack(playerPokemon2);
                wildPokemon2.attack(playerPokemon1);
                wildPokemon2.attack(playerPokemon2);
                displayHealth();
                isPlayerTurn = true; // Switch back to Player's turn after Opponent's attack
            }
        }
        
        	calculateBattleScore();
        	
    }
	
	public void catchPokemon() {
   	 if (playerPokemon1.getHp() == 0 && playerPokemon2.getHp() == 0) {
            System.out.println("\nPlayer Lose!");
        } else {
            System.out.println("\nPlayer can choose one of the wild Pokemon to catch:");
            System.out.println("1. " + wildPokemon1.getName());
            System.out.println("2. " + wildPokemon2.getName());

            int choice;
            do {
                System.out.print("Enter the number corresponding to your choice: ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 2);

            Pokemon chosenWildPokemon = (choice == 1) ? wildPokemon1 : wildPokemon2;

            // Now you can do something with the chosen wild Pokemon
            System.out.println("You chose to catch " + chosenWildPokemon.getName());
            
            String enter = scanner.nextLine();
            System.out.println("Press Enter to get a Pokeball !!");
	        enter = scanner.nextLine();
            Ball ball = randomBall();
            System.out.println("Use the " + ball.getName() + " to catch the pokemon!");
            ball.calculateCatchRate(chosenWildPokemon);
            
            System.out.println("Press Enter to Catch The pokemon!");
	         enter = scanner.nextLine();
            ball.tryToCatchPokemon();
           
            
       }
   	 
   }
	
	public void Heal() {
		if (playerPokemon1.getHp() <= 60 && playerPokemon2.getHp() <= 60) {
	
			String enter = scanner.nextLine();
            System.out.println("You got a chance to use a special skill ! Press Enter to have a chance to Heal !!");
	        enter = scanner.nextLine();
	        Random random = new Random();
	        int randomNumber = random.nextInt(3) + 1;
		        if (randomNumber == 2 || randomNumber == 3) {
		            // Call the method or code for the special skill
		            playerPokemon1.setHp(playerPokemon1.getHp() + 30);
		            playerPokemon2.setHp(playerPokemon2.getHp() + 30);
		            System.out.println("You got the chance to Heal! Press enter to continue the battle.");
		        } else {
		            // Your regular code here
		            System.out.println("You missed the chance.");
	        }
		        healUsed = true;
		}
	}	
		
	
	
	
			public Ball randomBall(){
			    	
			    	PokeBall b1 = new PokeBall();
			    	GreatBall b2 = new GreatBall();
			    	UltraBall b3 = new UltraBall();
			    	MasterBall b4 = new MasterBall();
			    	
			    	pokeballs.add(b1);
			    	pokeballs.add(b2);
			    	pokeballs.add(b3);
			    	pokeballs.add(b4);
			    	
			    	// Randomly select a pokeball type
			    	Random random = new Random();
			        int randomIndex = random.nextInt(pokeballs.size());
			        Ball randomPokeball = pokeballs.get(randomIndex);
			       
			        
			        return randomPokeball;
			    	
			    }
			
			

	private void displayHealth() {
	    System.out.printf(
	            "\nOpponent Pokemon HP: %s: %d, %s: %d\nPlayer Pokemon HP: %s: %d, %s: %d\n",
	            wildPokemon1.getName(), wildPokemon1.getHp(),
	            wildPokemon2.getName(), wildPokemon2.getHp(),
	            playerPokemon1.getName(), playerPokemon1.getHp(),
	            playerPokemon2.getName(), playerPokemon2.getHp()
	    );
	}
	
   public int calculateBattleScore() {
        return(Math.max(playerPokemon1.getHp() + playerPokemon2.getHp(),0)); // Final battle score based on Player 1's remaining HP
    }
}