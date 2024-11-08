import java.util.Random;
import java.util.Scanner;

public class Ball {

	 private String name;
	 private double catchRate;
	 

	    public Ball(String name) {
	        this.name = name;
	        
	       
	    }

	    public String getName() {
	        return name;
	    }
	    
	    public void setCatchRate(double catchRate) {
	    	this.catchRate = catchRate;
	    }
	    

	    public double getCatchRate() {
	        return catchRate;
	    }

	    
	    
	    public void calculateCatchRate(Pokemon p) {
	    	
	    }
	   
	    
	    public boolean tryToCatchPokemon() {
	        double randomValue = Math.random();
		        if (catchRate/100 >= randomValue) {
		            System.out.println("Congratulations! You successfully caught the Pokemon!");
		            offerTrade();
		            return true;
		        } else {
		            System.out.println("Oh no! The Pokemon broke free. Better luck next time!");
		            return false;
		        }
	    }
	    private void offerTrade() {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int randomNumber = random.nextInt(3) + 1;
	        if(randomNumber == 1 || randomNumber == 2) {
	        	System.out.println("Do you want to trade this Pokemon? (yes/no)");
		        String response = scanner.nextLine().toLowerCase();
			        if (response.equals("yes")) {
			            System.out.println("Great! Initiating trade...You can choose to trade either one of this pokemon");
			            System.out.println("1. Charizard \n2. Dewott");
			            int choice = scanner.nextInt();
			            
			            if (choice == 1) {
			                System.out.println("You chose Charizard! Trade successful.");
			                
			            } else if (choice == 2) {
			                System.out.println("You chose Dewott! Trade successful.");
			               
			            } else {
			                System.out.println("Invalid choice. No trade made.");
			            }
	
			            scanner.close();
			        }
			         else {
			            System.out.println("Okay, maybe next time. Enjoy your new Pokemon!");
			        }
	        }
	       	else {
	        	System.out.println("Sorry, you can't trade your Pokemon this time.");
	        }
	    }
}