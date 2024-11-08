
public class PokeBall extends Ball {
    public PokeBall() {
        super("PokeBall"); // Example catch rate, adjust as needed
    }
    
    public void calculateCatchRate(Pokemon chosenWildPokemon) {
        switch (chosenWildPokemon.getGrade()) {
            case 1:
                setCatchRate(60);
            case 2:
            	setCatchRate(50);
            case 3:
            	setCatchRate(40);
            case 4:
            	setCatchRate(30);
            default:
            	setCatchRate(30); // Default catch rate if the grade is not specified
        }
    }
}