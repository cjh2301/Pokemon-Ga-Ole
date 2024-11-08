public class Ice extends Pokemon {
	
	//constructors
	public Ice() {
		super();
	}
	
	public Ice(String name, int hp, int grade, int spAttack, int def) {
		super(name, "ice", hp, grade, spAttack, def);
	}
	
	//other method
	public void attack(Pokemon p) {
		//not very effective = 10
		if (p.getType()== "water" || p.getType()== "ice" || p.getType()== "fire") {
			p.setHp(p.getHp()- 10);
		}
		//normal effect = 20
		else if(p.getType()== "rock"){
			p.setHp(p.getHp()- 20);
		}
	}
	
	//toString
	@Override
	public String toString() {
		return String.format("ice %s", super.toString());
	}

}