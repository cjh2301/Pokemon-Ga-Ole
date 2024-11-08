
public class MasterBall extends Ball {
    public MasterBall() {
        super("Master Ball"); // Guaranteed catch rate
    }
    
    public void calculateCatchRate(Pokemon chosenWildPokemon) {
        switch (chosenWildPokemon.getGrade()) {
            case 1:
                setCatchRate(100);
            case 2:
            	setCatchRate(90);
            case 3:
            	setCatchRate(80);
            case 4:
            	setCatchRate(70);
            default:
            	setCatchRate(90); // Default catch rate if the grade is not specified
        }
    }
}