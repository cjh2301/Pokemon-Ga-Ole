
public class UltraBall extends Ball {
    public UltraBall() {
        super("Ultra Ball"); // Example catch rate, adjust as needed
    }
    
    public void calculateCatchRate(Pokemon chosenWildPokemon) {
        switch (chosenWildPokemon.getGrade()) {
            case 1:
                setCatchRate(80);
            case 2:
            	setCatchRate(70);
            case 3:
            	setCatchRate(60);
            case 4:
            	setCatchRate(50);
            default:
            	setCatchRate(70); // Default catch rate if the grade is not specified
        }
    }
}