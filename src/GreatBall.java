
public class GreatBall extends Ball {
    public GreatBall() {
        super("Great Ball"); // Example catch rate, adjust as needed        
        
    }
    
    public void calculateCatchRate(Pokemon chosenWildPokemon) {
        switch (chosenWildPokemon.getGrade()) {
            case 1:
                setCatchRate(70);
            case 2:
            	setCatchRate(60);
            case 3:
            	setCatchRate(50);
            case 4:
            	setCatchRate(40);
            default:
            	setCatchRate(50); // Default catch rate if the grade is not specified
        }
    }
}