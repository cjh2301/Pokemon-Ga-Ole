public class Rock extends Pokemon{
	
	//constructors
	public Rock() {
		super();
	}
	
	public Rock(String name, int hp, int grade, int spAttack, int def) {
		super(name, "rock", hp, grade, spAttack, def);
	}

	//other method
	public void attack(Pokemon p) {
		//normal effect =20
		if (p.getType()== "rock" || p.getType()== "water") {
			p.setHp(p.getHp()- 20);
		}
		//super effective = 30
		else if (p.getType()== "fire" || p.getType()== "ice"){
			p.setHp(p.getHp()- 30);
		}
	}

	//toString
	@Override
	public String toString() {
		return String.format("rock %s", super.toString());
	}
	
	
}