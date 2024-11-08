
public class Pokemon {

	//attributes
	private String name;
	private String type;
	private int hp;
	private int grade;
	private int spAttack;
	private int def;
	
	//constructors
	public Pokemon() {
		
	}
	
	public Pokemon(String name, String type, int hp, int grade, int spAttack, int def) {
		super();
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.grade = grade;
		this.spAttack = spAttack;
		this.def = def;
	}

	//setters/getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if (hp >0) {
				this.hp = hp;
				}
		else {
			this.hp = 0;
		}
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getSpAttack() {
		return spAttack;
	}

	public void setSpAttack(int spAttack) {
		this.spAttack = spAttack;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void attack(Pokemon p) {
		
	}
	
	
	

	// Helper method to display Pokemon details
	    public void displayPokemonDetails() {
	        System.out.println("Name: " + name);
	        System.out.println("HP: " + hp);
	        System.out.println("Type: " + type);
	        System.out.println("Grade: " + grade);
	        System.out.println("Attack: " + spAttack);
	        // Add more details if needed
	    }
	    
	 
	//toString
	@Override
	public String toString() {
		return String.format("pokemon [name=%s, type=%s, hp=%s, grade=%s, spAttack=%s, def=%s]", name, type, hp, grade, spAttack, def);
	}
}