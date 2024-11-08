import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;

public class Game {
	private ScoreList topScoresList = new ScoreList();
    private ArrayList<Pokemon> pokemonList1 = new ArrayList<>();
    private ArrayList<Pokemon> initialPokemons = new ArrayList<>();
    private ArrayList<Pokemon> playerPokemons = new ArrayList<>();
    private Pokemon pp1 , pp2 , op1, op2;
    private String playerName;
    
    Scanner scanner = new Scanner(System.in);

    public void startGame() {
    	playerName = Player.getPlayerName();
    	enterPokemon();
    	wildPokemon();
    	playerPokemon();
    	topScoresList.readTopScores();
    	generatePokemonSet(); // choose stage
    	catchOneOutOfThree(); // catch pokemon 
    	generateRandomWildPokemon(); // pokemon that we are fighting 
    	sendPokemonToBattle(); // let users choose pokemon for battle 
    	Battle Battle = new Battle(pp1, pp2, op1, op2);
    	Battle.startBattle(); // start battle
    	Battle.catchPokemon();
    	
    	
    	//scores
    	Score score1 = new Score(playerName , Battle.calculateBattleScore());
    	topScoresList.updateTopScores(score1);
    	System.out.println(topScoresList);
    	topScoresList.saveTopScores();
    	
    	
    }


    public void enterPokemon() {
		Fire p1 = new Fire ("Charmander", 80, 1, 20, 20);
		Rock p2 = new Rock ("Golem", 150, 3, 20, 20);
		Water p3 = new Water ("Magikarp", 70, 1, 20, 20);
		
		initialPokemons.add(p1);
		initialPokemons.add(p2);
		initialPokemons.add(p3);
	} 

    public void wildPokemon() {
		Fire p1 = new Fire ("Charmander", 80, 1, 20, 20);
		Rock p2 = new Rock ("Golem", 150, 3, 20, 20);
		Water p3 = new Water ("Magikarp", 70, 1, 20, 20);
		Ice p4 = new Ice ("Glaceon", 200, 4, 20, 20);
		Rock p5 = new Rock ("Regirock", 200, 4, 20,20);
		
		 pokemonList1.add(p1);
	     pokemonList1.add(p2);
	     pokemonList1.add(p3);
	     pokemonList1.add(p4);
	     pokemonList1.add(p5);
	       
	} 
    
    public void playerPokemon() {
    	Fire p1 = new Fire ("Flareon", 200, 4, 20, 20);
        Water p2 = new Water ("Psyduck", 120, 2, 20, 20);
        Ice p3 = new Ice ("Vanilluxe", 200, 4 , 20, 20);
        Rock p4 = new Rock ("Golem", 160 , 3 , 20 , 20);
        
        playerPokemons.add(p1);
        playerPokemons.add(p2);
        playerPokemons.add(p3);
        playerPokemons.add(p4);
    }
   
    public void sendPokemonToBattle() {

        System.out.println("\nChoose Pokemon to battle:");

     // Create an ArrayList with Pokémon names for options
        ArrayList<String> pokemonOptions = new ArrayList<>();
        ArrayList<Pokemon> playerOptions = new ArrayList<>();
        for (Pokemon pokemon : playerPokemons) {
            pokemonOptions.add(pokemon.toString());
            playerOptions.add(pokemon);
        }
        
        int count = 0;
        while ( count != 2) {
	        System.out.println("\nChoose a Pokémon to send:");
	        for (int i = 0; i < pokemonOptions.size(); i++) {
	            System.out.println((i + 1) + ". " + pokemonOptions.get(i));
	        }
	
	        // Get player's choice
	        System.out.print("Enter the number of the Pokémon you want to send: ");
	        int playerChoice = scanner.nextInt();
	
	        // Validate player's choice
	        if (playerChoice < 1 || playerChoice > pokemonOptions.size()+1) {
	            System.out.println("Invalid choice. Please choose a number in the list.");
	        } else {
	                System.out.println("Pokemon Chosen Successfully\n");
	                if (count == 0) {
	                	pp1 = playerOptions.get(playerChoice-1);
	                }
	                else {
	                	pp2 = playerOptions.get(playerChoice -1 );
	                }
	                pokemonOptions.remove(playerChoice-1);
	    	        playerOptions.remove(playerChoice-1);
	    	        count++;
	        }
	        
	        
        }
    }
    
    
    public void generatePokemonSet() {
      	 

   	        System.out.println("There are 5 stages you can choose. Choose 1 out of it!");

   	     // Create an ArrayList with Pokémon names for options
   	        ArrayList<String> pokemonOptions = new ArrayList<>();
   	        for (Pokemon pokemon : pokemonList1) {
   	            pokemonOptions.add(pokemon.getName());
   	        }

   	     // Display available Pokémon options
   	        System.out.println("Possible Pokemon in each stage :");
   	        for (int i = 0; i < pokemonOptions.size(); i++) {
   	            System.out.println((i + 1) + ". " + pokemonOptions.get(i));
   	        }

   	        // Get player's choice
   	        System.out.print("Enter the stage you want to play: ");
   	        int playerChoice = scanner.nextInt();

   	        // Validate player's choice
   	        if (playerChoice < 1 || playerChoice > 5) {
   	            System.out.println("Invalid choice. Please choose a number between 1 and 5.");
   	        } else {
   	                System.out.println("Welcome to stage " + pokemonOptions.get(playerChoice - 1) + "!");
   	        }

      }
 
    public void catchOneOutOfThree() {
        

        System.out.println("\nYou encounter three Pokémon.");

     // Create an ArrayList with Pokémon names for options
        ArrayList<String> pokemonOptions = new ArrayList<>();
        for (Pokemon pokemon : initialPokemons) {
            pokemonOptions.add(pokemon.getName());
        }

     // Display available Pokémon options
        System.out.println("Choose a Pokémon to catch:");
        for (int i = 0; i < pokemonOptions.size(); i++) {
            System.out.println((i + 1) + ". " + pokemonOptions.get(i));
        }

        // Get player's choice
        System.out.print("Enter the number of the Pokémon you want to catch: ");
        int playerChoice = scanner.nextInt();

        // Validate player's choice
        if (playerChoice < 1 || playerChoice > 3) {
            System.out.println("Invalid choice. Please choose a number between 1 and 3.");
        } else {
                System.out.println("Congratulations! You caught a " + pokemonOptions.get(playerChoice - 1) + "!");
        }

        playerPokemons.add(initialPokemons.get(playerChoice -1));
    }
    
    public void generateRandomWildPokemon() {
        Random random = new Random();

        // Generate two random indices to get two random Pokemon
        int index1 = random.nextInt(pokemonList1.size());
        int index2;
        do {
            index2 = random.nextInt(pokemonList1.size());
        } while (index2 == index1);

        // Get the two random Pokemon
        Pokemon wildPokemon1 = pokemonList1.get(index1);
        Pokemon wildPokemon2 = pokemonList1.get(index2);

        // Display details for the two random Pokemon
        System.out.println("Random Wild Pokemon 1:");
        wildPokemon1.displayPokemonDetails();

        System.out.println("\nRandom Wild Pokemon 2:");
        wildPokemon2.displayPokemonDetails();
        
        op1 = wildPokemon1;
        op2 = wildPokemon2;
    }
    
    
    
       
 


}