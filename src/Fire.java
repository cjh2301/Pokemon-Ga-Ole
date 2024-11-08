public class Fire extends Pokemon {
	
	
	//constructors
	public Fire() {
		super();
	}
	
	public Fire(String name, int hp, int grade, int spAttack, int def) {
		super(name, "fire", hp, grade, spAttack, def);
	}

	//other method
	public void attack(Pokemon p) {
		//not very effective = 10
		if (p.getType()== "fire"|| p.getType()== "rock" || p.getType()== "water") {
			p.setHp(p.getHp()- 10);
		}
		//super effective = 30
		else if (p.getType()== "ice"){
			p.setHp(p.getHp()- 30);
		}
	}
	
	//toString
	@Override
	public String toString() {
		return String.format("fire %s",super.toString());
	}
}