public class Water extends Pokemon{
	
	//constructors
	public Water() {
		super();
	}
	
	public Water(String name, int hp, int grade, int spAttack, int def){
		super(name,"water", hp, grade, spAttack, def);
	}

	//other method
	public void attack(Pokemon p) {
		//not very effective = 10
		if (p.getType()== "water" ) {
			p.setHp(p.getHp() - 10);
		}
		//normal effect = 20
		else if(p.getType()== "ice"){
			p.setHp(p.getHp()- 20);
		}
		//super effective = 30
		else if(p.getType()== "fire" || p.getType()== "rock"){
			p.setHp(p.getHp()- 30);
		}
	}
	//toString
	@Override
	public String toString() {
		return String.format("water %s", super.toString());
	}

}
